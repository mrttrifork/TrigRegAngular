import {Component, inject, Input} from '@angular/core';
import {MatFormField, MatHint, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {TimeRegistrationDayComponent} from "../time-registration-day/time-registration-day.component";
import {MatCardModule} from "@angular/material/card";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {TaskAndTasklessRegistrationInterval} from "../../model/TaskAndTasklessRegistrationInterval";
import {MatTooltip} from "@angular/material/tooltip";
import {MatDialog} from "@angular/material/dialog";
import {TagTimeRegistrationRequest, TimeRegistrationService} from "../../generated";
import {AssociateTaskDialogComponent} from "../dialog/associate-task-dialog/associate-task-dialog.component";
import {firstValueFrom} from "rxjs/internal/firstValueFrom";

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
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatTooltip,
  ],
  templateUrl: './task-registration.component.html',
  styleUrl: './task-registration.component.scss'
})
export class TaskRegistrationComponent {
  @Input({required: true}) task!: TaskAndTasklessRegistrationInterval;

  private dialog = inject(MatDialog);
  private timeRegistrationService = inject(TimeRegistrationService);

  public hasDescription(): boolean {
    return typeof this.task.taskDescription === "string";
  }

  public openAssociateTaskDialog() {
    const dialogRef = this.dialog.open<AssociateTaskDialogComponent, any, number>(
      AssociateTaskDialogComponent, {width: "800px"});
    dialogRef.afterClosed().subscribe({
      next: async taskId => {
        if (taskId) {
          for (const dayTimeRegistrations of this.task.dailyRegistrations || []) {
            for (const {timeRegistrationId, tags} of dayTimeRegistrations.timeRegistrations) {
              const timeRegistrationTags = tags.reduce<TagTimeRegistrationRequest[]>((sum, tag) => {
                if (tag.tagRegistration) {
                  sum.push({
                    tagConfigurationId: tag.tagConfigurationMetadata.tagConfigurationId,
                    value: tag.tagRegistration.tagValue
                  });
                }
                return sum;
              }, []);
              await firstValueFrom(this.timeRegistrationService.associateTimeRegistrationWithTask({
                taskId: taskId,
                timeRegistrationId: timeRegistrationId,
                tags: timeRegistrationTags
              }));
            }
          }
        }
      }
    });
  }
}
