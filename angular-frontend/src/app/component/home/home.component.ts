import {Component, computed, effect, inject, Signal, signal, WritableSignal} from '@angular/core';
import {AsyncPipe, JsonPipe} from "@angular/common";
import {
  OverviewPeriod,
  TaskCreateResponseInner,
  TaskService,
  TimeRegistrationsByTaskResponse,
  TimeRegistrationService
} from "../../generated";
import {firstValueFrom} from "rxjs";
import {MatAutocompleteModule, MatAutocompleteSelectedEvent} from "@angular/material/autocomplete";
import {FormBuilder, FormControl, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from '@angular/material/input';
import {DateTime} from "luxon";
import {MatButton} from "@angular/material/button";
import {toSignal} from "@angular/core/rxjs-interop";
import {TotalLineComponent} from "../total-line/total-line.component";
import {MatCardModule} from "@angular/material/card";
import {TaskRegistrationComponent} from "../task-registration/task-registration.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [JsonPipe, AsyncPipe, MatFormFieldModule, MatIconModule, MatInputModule, ReactiveFormsModule, MatAutocompleteModule, MatOptionModule, MatButton, TotalLineComponent, MatCardModule, TaskRegistrationComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  readonly timeRegistrationService = inject(TimeRegistrationService);
  readonly taskService = inject(TaskService);
  readonly formBuilder = inject(FormBuilder);

  taskSearchControl: FormControl<string | TaskCreateResponseInner | null> = new FormControl('');

  taskSearchSignal = toSignal(this.taskSearchControl.valueChanges);
  filteredOptionsSignal: Signal<TaskCreateResponseInner[]> = computed(() => {
    const searchedValue = this.taskSearchSignal();
    const tasks = this.tasksSignal();

    if (tasks) {
      const searchedTaskName = typeof searchedValue === 'string' ? searchedValue : searchedValue?.name;
      if (!searchedTaskName) {
        return this.narrowSearch(tasks);
      }
      const searchedTaskNameLowerCase = searchedTaskName.toLowerCase();
      const searchedTasksBySpace = searchedTaskNameLowerCase.split(" ");
      const resultsFound = tasks.filter(task => {
        const taskLowerCased = task.name.toLowerCase();
        return searchedTasksBySpace.every(currString => taskLowerCased.includes(currString));
      })
      return this.narrowSearch(resultsFound);
    }
    return [];
  });

  private narrowSearch(tasks: TaskCreateResponseInner[]): TaskCreateResponseInner[] {
    if (tasks.length <= 5) {
      return tasks;
    } else {
      const fakeTask: TaskCreateResponseInner = {taskId: -1, name: "...", kmEligible: false}
      return tasks.slice(0, 4).concat(fakeTask);
    }
  }

  taskControl = new FormControl<string | TimeRegistrationsByTaskResponse>('');

  timeRegistrationByTaskSignal: WritableSignal<TimeRegistrationsByTaskResponse | undefined> = signal(undefined);
  tasksSignal: WritableSignal<TaskCreateResponseInner[] | undefined> = signal(undefined);

  private effectRef = effect(() => {
    this.timeRegistrationService.getTaskTimeRegistrationsOverview(DateTime.now().toISODate(), OverviewPeriod.Week).subscribe({
      next: value => {
        this.timeRegistrationByTaskSignal.set(value);
      }
    })
    this.taskService.getTasksForUser().subscribe({
      next: value => {
        this.tasksSignal.set(value);
      }
    })
  }, {allowSignalWrites: true})

  displayFn(task: TaskCreateResponseInner): string {
    return task?.name || '';
  }

  public async addTimeRegistration(timeRegistrationId?: number) {
    await firstValueFrom(this.timeRegistrationService.addTimeRegistrationForUser({
      taskId: timeRegistrationId || 1,
      date: DateTime.now().toISODate(),
      duration: "PT1H30M"
    }));
  }

  public getWeekRangeAsString() {
    const startOfWeek = DateTime.now().startOf("week");
    const endOfWeek = DateTime.now().endOf("week");

    return `Total for week: ${startOfWeek.weekNumber}; ${startOfWeek.toFormat("dd-MM-yyyy")} – ${endOfWeek.toFormat("dd-MM-yyyy")}`
  }

  public selected($event: MatAutocompleteSelectedEvent) {
    const task = $event.option.value as TaskCreateResponseInner;
    this.addTimeRegistration(task.taskId)
    this.taskSearchControl.reset();
  }
}
