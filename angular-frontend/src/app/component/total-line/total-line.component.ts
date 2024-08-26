import {Component, computed, inject} from '@angular/core';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {JsonPipe} from "@angular/common";
import DurationConverter from "../../util/DurationConverter";
import {DateTime} from "luxon";
import {TotalTimeService} from "../../service/total-time.service";
import {TasklessTimeRegistrationsInterval, TaskTimeRegistrationsInterval} from "../../generated";

interface DateAndMinutes {
  date: string;
  taskMinutes: number;
  tasklessMinutes: number;
}

@Component({
  selector: 'app-total-line',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    JsonPipe
  ],
  templateUrl: './total-line.component.html',
  styleUrl: './total-line.component.scss'
})
export class TotalLineComponent {

  private totalTimeService = inject(TotalTimeService);

  dateToMinuteSignal = computed<DateAndMinutes[]>(() => {
    const subs = this.totalTimeService.getTimeRegistrationSignalAsReadonly()();
    if (!subs) {
      return [];
    }
    const dateToMinutes = [...subs.taskTimeRegistrations, ...subs.tasklessTimeRegistrations].reduce<{
      [K: string]: { taskMinutes: number, tasklessMinutes: number }
    }>((sum, currentValue) => {
      for (const dayTimeRegistrations of currentValue.dailyRegistrations) {
        const date = dayTimeRegistrations.date
        if (!sum[date]) {
          sum[date] = {taskMinutes: 0, tasklessMinutes: 0};
        }
        for (const timeRegistrations of dayTimeRegistrations.timeRegistrations) {
          const minutes = DurationConverter.getMinutes(timeRegistrations.duration);
          if (this.isTasklessTimeRegistrationsInterval(currentValue)) {
            sum[date].tasklessMinutes = sum[date].tasklessMinutes + minutes;
          } else {
            sum[date].taskMinutes = sum[date].taskMinutes + minutes;
          }
        }
      }
      return sum;
    }, {});
    return Object.entries(dateToMinutes).map<DateAndMinutes>(([key, {taskMinutes, tasklessMinutes}]) => {
      return {
        date: key,
        taskMinutes: taskMinutes,
        tasklessMinutes: tasklessMinutes,
      }
    });
  });

  public formatDanishDate(isoDate: string): string {
    return DateTime.fromISO(isoDate).toFormat("dd/MM")
  }

  public getHours({taskMinutes, tasklessMinutes}: DateAndMinutes): string {
    const totalMinutes = DurationConverter.toHumanFromMinutes(taskMinutes + tasklessMinutes);
    const draftMinutes = DurationConverter.toHumanFromMinutes(tasklessMinutes);

    if (tasklessMinutes) {
      return `${totalMinutes}h (${draftMinutes}h)`
    }
    return `${totalMinutes}h`;
  }

  protected readonly Object = Object;

  private isTasklessTimeRegistrationsInterval(currentValue: TasklessTimeRegistrationsInterval | TaskTimeRegistrationsInterval): currentValue is TasklessTimeRegistrationsInterval {
    return "taskDescription" in currentValue;
  }
}
