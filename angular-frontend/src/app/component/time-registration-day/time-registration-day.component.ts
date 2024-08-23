import {Component, effect, inject, Input} from '@angular/core';
import {MatFormField} from "@angular/material/form-field";
import {DateTime} from "luxon";
import {DayTimeRegistrations, TimeRegistration, TimeRegistrationService, TimeRegistrationStatus} from "../../generated";
import DurationConverter from "../../util/DurationConverter";
import {AbstractControl, FormControl, ReactiveFormsModule, ValidationErrors} from "@angular/forms";
import {toSignal} from "@angular/core/rxjs-interop";
import {MatInputModule} from "@angular/material/input";
import {firstValueFrom} from "rxjs/internal/firstValueFrom";
import {TotalTimeService} from "../../service/total-time.service";
import {TaskAndTasklessRegistrationInterval} from "../../model/TaskAndTasklessRegistrationInterval";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-time-registration-day',
  standalone: true,
  imports: [
    MatFormField,
    ReactiveFormsModule,
    MatInputModule
  ],
  templateUrl: './time-registration-day.component.html',
  styleUrl: './time-registration-day.component.scss'
})
export class TimeRegistrationDayComponent {

  private timeRegistrationService = inject(TimeRegistrationService);
  private totalTimeService = inject(TotalTimeService);
  private _dayTimeRegistrations!: DayTimeRegistrations;

  dayRegistrationFormControl: FormControl<string | null> = new FormControl('', {
    updateOn: "blur",
    validators: [
      (control: AbstractControl<string>): ValidationErrors | null => {
        const value = control.value;

        if (!DurationConverter.isValidHumanDuration(value)) {
          return {
            invalidInput: "Field is not a valid input"
          };
        }
        return null;
      }
    ]
  });

  timeRegistrationChange = toSignal(this.dayRegistrationFormControl.valueChanges);

  get dayTimeRegistrations(): DayTimeRegistrations {
    return this._dayTimeRegistrations;
  }

  @Input({required: true}) task!: TaskAndTasklessRegistrationInterval;

  @Input({required: true}) set dayTimeRegistrations(value: DayTimeRegistrations) {
    this._dayTimeRegistrations = value;
    const firstTimeRegistration = value.timeRegistrations.find(timeRegistration => !!timeRegistration);
    if (firstTimeRegistration) {
      const humanDuration = DurationConverter.convertToHumanDuration(firstTimeRegistration.duration);
      this.dayRegistrationFormControl.setValue(humanDuration);
    }
  }

  private effectRef = effect(async () => {
    const timeChange = this.timeRegistrationChange();
    if (this.dayRegistrationFormControl.dirty && this.dayRegistrationFormControl.valid) {
      try {
        const [firstRegistration] = this.dayTimeRegistrations.timeRegistrations;
        const formattedTimeChange = timeChange ? DurationConverter.convertToISO8601Duration(timeChange) : undefined;
        if (!firstRegistration && formattedTimeChange) {
          const newRegistration = {
            date: this.dayTimeRegistrations.date,
            duration: formattedTimeChange,
            taskId: this.task.task?.taskId,
            description: this.task.taskDescription
          };
          const response = await firstValueFrom(this.timeRegistrationService.addTimeRegistrationForUser(newRegistration));
          const newTimeRegistration: TimeRegistration = {
            ...newRegistration, ...{
              timeRegistrationId: response.id,
              status: TimeRegistrationStatus.Valid,
              tags: []
            }
          };
          this.dayTimeRegistrations.timeRegistrations.push(newTimeRegistration);
        } else {
          if (formattedTimeChange) {
            const response = await firstValueFrom(this.timeRegistrationService.updateTimeRegistrationForUser(firstRegistration.timeRegistrationId, {
              duration: formattedTimeChange
            }));
            this.dayTimeRegistrations.timeRegistrations.splice(0, 1, {
              timeRegistrationId: response.id,
              status: TimeRegistrationStatus.Valid,
              tags: [],
              duration: formattedTimeChange
            });
          } else {
            await firstValueFrom(this.timeRegistrationService.deleteTimeRegistration(firstRegistration.timeRegistrationId));
            this.dayTimeRegistrations.timeRegistrations.splice(0, 1);
          }
        }
        this.totalTimeService.patch();
      } catch (error) {
        if (error instanceof HttpErrorResponse) {
          this.dayRegistrationFormControl.setErrors({
            registrationFailed: error.error.message
          })
        }
      }
    }
  });

  public formatShortDay(isoDate: string): string {
    return DateTime.fromISO(isoDate).toFormat("EEE");
  }

  public formatDanishDate(isoDate: string): string {
    return DateTime.fromISO(isoDate).toFormat("dd/MM")
  }
}
