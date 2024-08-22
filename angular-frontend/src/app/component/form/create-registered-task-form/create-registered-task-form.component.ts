import {
  Component,
  computed,
  effect,
  EventEmitter,
  inject,
  OnInit,
  Output,
  Signal,
  signal,
  WritableSignal
} from '@angular/core';
import {
  MatAutocomplete,
  MatAutocompleteSelectedEvent,
  MatAutocompleteTrigger,
  MatOption
} from "@angular/material/autocomplete";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {OverviewPeriod, TaskCreateResponseInner, TaskService} from "../../../generated";
import {DateTime} from "luxon";
import {toSignal} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-create-registered-task-form',
  standalone: true,
    imports: [
        MatAutocomplete,
        MatAutocompleteTrigger,
        MatFormField,
        MatInput,
        MatLabel,
        MatOption,
        ReactiveFormsModule
    ],
  templateUrl: './create-registered-task-form.component.html',
  styleUrl: './create-registered-task-form.component.scss'
})
export class CreateRegisteredTaskFormComponent implements OnInit {
  readonly taskService = inject(TaskService);

  @Output() private onRegisteredTaskRegistered = new EventEmitter<FormControl<string | TaskCreateResponseInner | null>>();

  public ngOnInit(): void {
    this.onRegisteredTaskRegistered.emit(this.taskSearchControl);
  }

  taskSearchControl: FormControl<string | TaskCreateResponseInner | null> = new FormControl('');

  taskSearchSignal = toSignal(this.taskSearchControl.valueChanges);

  private narrowSearch(tasks: TaskCreateResponseInner[]): TaskCreateResponseInner[] {
    if (tasks.length <= 5) {
      return tasks;
    } else {
      const fakeTask: TaskCreateResponseInner = {taskId: -1, name: "...", kmEligible: false}
      return tasks.slice(0, 4).concat(fakeTask);
    }
  }

  displayFn(task: TaskCreateResponseInner): string {
    return task?.name || '';
  }

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

  tasksSignal: WritableSignal<TaskCreateResponseInner[] | undefined> = signal(undefined);

  private effectRef = effect(() => {
    this.taskService.getTasksForUser().subscribe({
      next: value => {
        this.tasksSignal.set(value);
      }
    })
  }, {allowSignalWrites: true})
}
