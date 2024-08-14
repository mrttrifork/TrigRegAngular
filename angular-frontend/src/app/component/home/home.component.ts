import {Component, effect, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {AsyncPipe, JsonPipe} from "@angular/common";
import {TimeRegistrationResponse, TimeRegistrationsByTaskResponseInner, TimeRegistrationService} from "../../generated";
import {firstValueFrom} from "rxjs";
import {MatAutocompleteModule, MatAutocompleteSelectedEvent} from "@angular/material/autocomplete";
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from '@angular/material/input';
import {TaskLineComponent, TaskLineFormGroup} from "../task-line/task-line.component";
import {DateTime} from "luxon";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [JsonPipe, AsyncPipe, MatFormFieldModule, MatIconModule, MatInputModule, ReactiveFormsModule, MatAutocompleteModule, MatOptionModule, TaskLineComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  readonly timeRegistrationService = inject(TimeRegistrationService);
  readonly formBuilder = inject(FormBuilder);

  tasksFormArray: FormArray<FormGroup<TaskLineFormGroup>> = new FormArray<FormGroup<TaskLineFormGroup>>([]);


  taskControl = new FormControl<string | TimeRegistrationsByTaskResponseInner>('');

  timeRegistrationSignal: WritableSignal<TimeRegistrationResponse[] | undefined> = signal(undefined);

  private effectRef = effect(() => {
      this.timeRegistrationService.getTimeRegistrationsForUser().subscribe({
        next: value => {
          this.timeRegistrationSignal.set(value);
        }
      })
  }, {allowSignalWrites: true})

  ngOnInit(): void {
  }

  public async addTimeRegistration() {
    await firstValueFrom(this.timeRegistrationService.addTimeRegistrationForUser({
      taskId: 1,
      date: "2024-05-13",
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
    const formGroup: FormGroup<TaskLineFormGroup> = this.formBuilder.group({
      monday: this.formBuilder.control(''),
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
}
