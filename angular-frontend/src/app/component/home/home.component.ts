import {Component, computed, effect, inject, Signal, signal, WritableSignal} from '@angular/core';
import {AsyncPipe, JsonPipe} from "@angular/common";
import {
  PeriodEnum,
  TaskCreateResponseInner,
  TaskService,
  TimeRegistrationResponse,
  TimeRegistrationsByTaskResponseInner,
  TimeRegistrationService
} from "../../generated";
import {firstValueFrom} from "rxjs";
import {MatAutocompleteModule, MatAutocompleteSelectedEvent} from "@angular/material/autocomplete";
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from '@angular/material/input';
import {TaskLineComponent, TaskLineFormGroup} from "../task-line/task-line.component";
import {DateTime} from "luxon";
import {MatButton} from "@angular/material/button";
import DurationConverter from "../../util/DurationConverter";
import {toSignal} from "@angular/core/rxjs-interop";
import {TotalLineComponent} from "../total-line/total-line.component";
import {MatCardModule} from "@angular/material/card";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [JsonPipe, AsyncPipe, MatFormFieldModule, MatIconModule, MatInputModule, ReactiveFormsModule, MatAutocompleteModule, MatOptionModule, TaskLineComponent, MatButton, TotalLineComponent, MatCardModule],
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

  tasksFormArray: FormArray<FormGroup<TaskLineFormGroup>> = new FormArray<FormGroup<TaskLineFormGroup>>([]);

  taskControl = new FormControl<string | TimeRegistrationsByTaskResponseInner>('');

  timeRegistrationSignal: WritableSignal<TimeRegistrationResponse[] | undefined> = signal(undefined);
  tasksSignal: WritableSignal<TaskCreateResponseInner[] | undefined> = signal(undefined);

  private effectRef = effect(() => {
    this.timeRegistrationService.getTimeRegistrationsForUser().subscribe({
      next: value => {
        this.timeRegistrationSignal.set(value);
      }
    })
    this.timeRegistrationService.getTaskTimeRegistrationsOverview(DateTime.now().toISODate(), PeriodEnum.Week).subscribe({
      next: value => {
        for (const timeRegistrationsByTaskResponseInner of value) {
          this.addTask(timeRegistrationsByTaskResponseInner);
        }
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

  private filterTasks(tasks: TimeRegistrationsByTaskResponseInner[]): TimeRegistrationsByTaskResponseInner[] {
    return tasks
      .filter(({taskId, taskName}) => {
        if (!taskName) {
          return false;
        }
        const taskValue = typeof this.taskControl.value === "string" ? this.taskControl.value : this.taskControl.value?.taskName ?? "";
        return taskName.includes(taskValue) || taskName.toLowerCase().includes(taskValue.toLowerCase());
      })
      .sort((a, b) => (a.taskName || "").localeCompare(b.taskName || ""));
  }

  public optionSelected($event: MatAutocompleteSelectedEvent) {
    const category = $event.option.value;
    if (category) {
      this.addTask(category as TimeRegistrationsByTaskResponseInner);
    }
  }

  private addTask(category: TimeRegistrationsByTaskResponseInner) {
    const firstDuration = category.timeRegistrations?.[0].duration || "";
    const addDuration = firstDuration ? DurationConverter.convertToHumanDuration(firstDuration) : "";
    const formGroup: FormGroup<TaskLineFormGroup> = this.formBuilder.group({
      monday: this.formBuilder.control(addDuration),
      tuesday: this.formBuilder.control(''),
      wednesday: this.formBuilder.control(''),
      thursday: this.formBuilder.control(''),
      friday: this.formBuilder.control(''),
      saturday: this.formBuilder.control(''),
      sunday: this.formBuilder.control(''),
      taskId: category.taskId,
      taskName: category.taskName,
      weekNumber: DateTime.now().weekNumber
    });
    this.tasksFormArray.push(formGroup);
    this.taskControl.reset();
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
    console.log(task);
  }
}
