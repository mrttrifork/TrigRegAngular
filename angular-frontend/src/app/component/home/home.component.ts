import {Component, effect, inject, signal, WritableSignal} from '@angular/core';
import {AsyncPipe, JsonPipe} from "@angular/common";
import {OverviewPeriod, TimeRegistrationsByTaskResponse, TimeRegistrationService} from "../../generated";
import {firstValueFrom} from "rxjs";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from '@angular/material/input';
import {DateTime} from "luxon";
import {MatButton, MatFabButton} from "@angular/material/button";
import {TotalLineComponent} from "../total-line/total-line.component";
import {MatCardModule} from "@angular/material/card";
import {TaskRegistrationComponent} from "../task-registration/task-registration.component";
import {TotalTimeService} from "../../service/total-time.service";
import {
  UnregisteredTaskRegistrationComponent
} from "../unregistered-task-registration/unregistered-task-registration.component";
import {MatDialog} from "@angular/material/dialog";
import {CreateTaskDialogComponent, TaskOrDescription} from "../dialog/create-task-dialog/create-task-dialog.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [JsonPipe, AsyncPipe, MatFormFieldModule, MatIconModule, MatInputModule, ReactiveFormsModule, MatAutocompleteModule, MatOptionModule, MatButton, TotalLineComponent, MatCardModule, TaskRegistrationComponent, UnregisteredTaskRegistrationComponent, MatFabButton],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  readonly timeRegistrationService = inject(TimeRegistrationService);

  readonly totalTimeService = inject(TotalTimeService);
  private readonly dialog = inject(MatDialog);

  public openCreateDialog() {
    const dialogRef = this.dialog.open<CreateTaskDialogComponent, any, TaskOrDescription | undefined>(
      CreateTaskDialogComponent, {width: "800px"});
    dialogRef.afterClosed().subscribe({
      next: async value => {
        if (value) {
          const extraTasks = value.taskId ? [value.taskId] : [0];
          this.timeRegistrationService.getTaskTimeRegistrationsOverview(DateTime.now().toISODate(), OverviewPeriod.Week, extraTasks).subscribe({
            next: value => {
              this.totalTimeService.next(value);
              this.timeRegistrationByTaskSignal.set(value);
            }
          })
        }
      }
    });
  }

  timeRegistrationByTaskSignal: WritableSignal<TimeRegistrationsByTaskResponse | undefined> = signal(undefined);


  private effectRef = effect(() => {
    this.timeRegistrationService.getTaskTimeRegistrationsOverview(DateTime.now().toISODate(), OverviewPeriod.Week).subscribe({
      next: value => {
        this.totalTimeService.next(value);
        this.timeRegistrationByTaskSignal.set(value);
      }
    })
  }, {allowSignalWrites: true})

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

    return `Total for week ${startOfWeek.weekNumber} - ${startOfWeek.toFormat("dd-MM-yyyy")} to ${endOfWeek.toFormat("dd-MM-yyyy")}`
  }
}
