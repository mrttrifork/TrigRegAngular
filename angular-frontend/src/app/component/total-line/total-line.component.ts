import {Component, Input, signal, WritableSignal} from '@angular/core';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {JsonPipe} from "@angular/common";
import {TimeRegistrationsByTaskResponse} from "../../generated";
import {TimeRegistrationDayComponent} from "../time-registration-day/time-registration-day.component";
import DurationConverter from "../../util/DurationConverter";
import {DateTime} from "luxon";

@Component({
  selector: 'app-total-line',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    JsonPipe,
    TimeRegistrationDayComponent
  ],
  templateUrl: './total-line.component.html',
  styleUrl: './total-line.component.scss'
})
export class TotalLineComponent {
  private _taskResponse?: TimeRegistrationsByTaskResponse;

  get taskResponse(): TimeRegistrationsByTaskResponse | undefined {
    return this._taskResponse;
  }

  @Input({required: true}) set taskResponse(value: TimeRegistrationsByTaskResponse | undefined) {
    this._taskResponse = value;
    this.mapTaskToDates();
  }

  dateToMinuteSignal: WritableSignal<{ [K: string]: number } | undefined> = signal(undefined);

  public mapTaskToDates() {
    const dateToMinutes = this.taskResponse?.taskTimeRegistrations.reduce<{
      [K: string]: number
    }>((sum, currentValue) => {
      for (const dayTimeRegistrations of currentValue.dailyRegistrations) {
        const date = dayTimeRegistrations.date
        if (!sum[date]) {
          sum[date] = 0;
        }
        for (const timeRegistrations of dayTimeRegistrations.timeRegistrations) {
          const minutes = DurationConverter.getMinutes(timeRegistrations.duration);
          sum[date] = sum[date] + minutes;
        }
      }
      return sum;
    }, {});
    if (dateToMinutes) {
      this.dateToMinuteSignal.set(dateToMinutes);
    }
  }

  protected readonly Object = Object;
  protected readonly DateTime = DateTime;
}
