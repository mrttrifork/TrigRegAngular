import {Component, Input, OnInit, signal, WritableSignal} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {WeekNumbers} from "luxon/src/datetime";
import {DateTime} from "luxon";
import {TagConfiguration} from "../../generated";
import {JsonPipe} from "@angular/common";

export interface TaskLineFormGroup {
  taskId: FormControl<number | undefined | null>;
  taskName: FormControl<string | undefined | null>;
  weekNumber: FormControl<WeekNumbers | null>;
  monday: FormControl<string | null>;
  tuesday: FormControl<string | null>;
  wednesday: FormControl<string | null>;
  thursday: FormControl<string | null>;
  friday: FormControl<string | null>;
  saturday: FormControl<string | null>;
  sunday: FormControl<string | null>;
}

@Component({
  selector: 'app-task-line',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    JsonPipe
  ],
  templateUrl: './task-line.component.html',
  styleUrl: './task-line.component.scss'
})
export class TaskLineComponent implements OnInit {
  @Input({required: true}) formGroup!: FormGroup<TaskLineFormGroup>;

  tagConfigurationResponse: WritableSignal<TagConfiguration[] | undefined> = signal(undefined);

  dates: string[] = [];

  public ngOnInit() {
    const weekNumber = this.formGroup.controls.weekNumber.value;
    if (weekNumber) {
      let fromObject = DateTime.fromObject({
        weekNumber
      });
      let dayOne = fromObject.startOf("week");
      if (dayOne.isValid) {
        for (let i = 0; i < 7; i++) {
          this.dates.push(dayOne.toFormat("dd-MM"));
          dayOne = dayOne.plus({days: 1});
        }
      }
    }
    const taskId = this.formGroup.controls.taskId.value;
    if (taskId) {
    }
  }
}
