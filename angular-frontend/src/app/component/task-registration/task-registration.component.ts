import {Component, Input} from '@angular/core';
import {MatFormField, MatHint, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {TaskTimeRegistrationsInterval} from "../../generated";
import {TimeRegistrationDayComponent} from "../time-registration-day/time-registration-day.component";
import {MatCardModule} from "@angular/material/card";

@Component({
  selector: 'app-task-registration',
  standalone: true,
  imports: [
    MatFormField,
    MatHint,
    MatInput,
    MatLabel,
    ReactiveFormsModule,
    TimeRegistrationDayComponent,
    MatCardModule
  ],
  templateUrl: './task-registration.component.html',
  styleUrl: './task-registration.component.scss'
})
export class TaskRegistrationComponent {
  @Input({required: true}) task!: TaskTimeRegistrationsInterval;

  public getTaskName(taskName: string): string[] {
    return taskName.split(" / ");
  }

  public getMarginLeft(index: number): string[] {
    return [`ml-${index}`];
  }
}
