import {Component, computed, inject} from '@angular/core';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {JsonPipe} from "@angular/common";
import {TimeRegistrationDayComponent} from "../time-registration-day/time-registration-day.component";
import DurationConverter from "../../util/DurationConverter";
import {DateTime} from "luxon";
import {TotalTimeService} from "../../service/total-time.service";
import {toSignal} from "@angular/core/rxjs-interop";

interface DateAndMinutes {
  date: string;
  minutes: number;
}

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

  private totalTimeService = inject(TotalTimeService);

  private subscription = toSignal(this.totalTimeService.getObservable());
  dateToMinuteSignal = computed<DateAndMinutes[]>(() => {
    const subs = this.subscription();
    if (!subs) {
      return [];
    }
    const dateToMinutes = subs.taskTimeRegistrations.reduce<{
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
    return Object.entries(dateToMinutes).map<DateAndMinutes>(([key, value]) => {
      return {
        date: key,
        minutes: value
      }
    });
  });

  public formatDanishDate(isoDate: string): string {
    return DateTime.fromISO(isoDate).toFormat("dd-MM")
  }

  protected readonly Object = Object;
  protected readonly DurationConverter = DurationConverter;
}
