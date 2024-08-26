import {Component, inject} from '@angular/core';
import {
  TagRegistrationFormGroup,
  TagsFormGroup,
  TaskEditFormComponent,
  TimeRegistrationFormGroup
} from "../../form/task-edit-form/task-edit-form.component";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {TaskAndTasklessRegistrationInterval} from "../../../model/TaskAndTasklessRegistrationInterval";
import {
  CreateRegisteredTaskFormComponent
} from "../../form/create-registered-task-form/create-registered-task-form.component";
import {
  CreateUnregisteredTaskFormComponent
} from "../../form/create-unregistered-task-form/create-unregistered-task-form.component";
import {MatButton} from "@angular/material/button";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {FormGroup, ReactiveFormsModule, ɵFormArrayValue, ɵFormGroupValue, ɵTypedOrUntyped} from "@angular/forms";
import {TagTimeRegistrationRequest, TimeRegistrationTag} from "../../../generated";
import {ExtendedTimeRegistrationCRUD} from "../../../model/ExtendedCreateUpdateDeleteTimeRegistration";
import DurationConverter from "../../../util/DurationConverter";

@Component({
  selector: 'app-task-edit-dialog',
  standalone: true,
  imports: [
    TaskEditFormComponent,
    CreateRegisteredTaskFormComponent,
    CreateUnregisteredTaskFormComponent,
    MatButton,
    MatButtonToggle,
    MatButtonToggleGroup,
    MatDialogActions,
    MatDialogClose,
    MatDialogContent,
    MatDialogTitle,
    ReactiveFormsModule
  ],
  templateUrl: './task-edit-dialog.component.html',
  styleUrl: './task-edit-dialog.component.scss'
})
export class TaskEditDialogComponent {
  task: TaskAndTasklessRegistrationInterval = inject(MAT_DIALOG_DATA);
  public dialogRef: MatDialogRef<TaskEditDialogComponent, ExtendedTimeRegistrationCRUD[]> = inject(MatDialogRef<TaskEditDialogComponent, ExtendedTimeRegistrationCRUD[]>);
  private tagRegistrationFormGroup?: TagRegistrationFormGroup;

  public editTask() {
    if (this.tagRegistrationFormGroup) {
      if (this.tagRegistrationFormGroup.valid) {
        const returnValue = this.convertFormGroupToTask(this.tagRegistrationFormGroup.value)
        this.dialogRef.close(returnValue);
        return;
      }
    }
    this.dialogRef.close(undefined);
  }

  public taskRegistration(tagRegistrationFormGroup: TagRegistrationFormGroup) {
    this.tagRegistrationFormGroup = tagRegistrationFormGroup
  }

  private convertFormGroupToTask(value: ɵTypedOrUntyped<FormGroup<TagsFormGroup>, ɵFormArrayValue<FormGroup<TagsFormGroup>>, any>): ExtendedTimeRegistrationCRUD[] {
    return value
      .map(form => (form.dayRegistrations || [])
        .map<ExtendedTimeRegistrationCRUD | undefined>(dayRegistration => this.getTimeRegistration(dayRegistration))
        .filter(Boolean) as ExtendedTimeRegistrationCRUD[])
      .flat();
  }

  private getTimeRegistration(dayRegistration: ɵFormGroupValue<TimeRegistrationFormGroup>): ExtendedTimeRegistrationCRUD | undefined {
    if (dayRegistration.timeRegistration?.timeRegistrationId) {
      if (!dayRegistration.duration) {
        return {
          type: "delete",
          timeRegistrationId: dayRegistration.timeRegistration.timeRegistrationId
        }
      } else {
        return {
          type: "update",
          timeRegistrationId: dayRegistration.timeRegistration.timeRegistrationId,
          duration: DurationConverter.convertToISO8601Duration(dayRegistration.duration)
        }
      }
    } else {
      const isoDuration = DurationConverter.convertToISO8601Duration(dayRegistration.duration || "")
      if (isoDuration && dayRegistration.date) {
        return {
          type: "create",
          tags: this.getTimeRegistrationRequest(dayRegistration.timeRegistration?.tags),
          duration: isoDuration,
          date: dayRegistration.date,
          taskId: this.task.task?.taskId,
          description: this.task.task?.taskDescription
        }
      }
    }
    return undefined;
  }

  private getTimeRegistrationRequest(tags: Array<TimeRegistrationTag> | undefined): TagTimeRegistrationRequest[] | undefined {
    if (!tags) {
      return undefined;
    }
    return tags.map<TagTimeRegistrationRequest>(tag => {
      return {
        tagConfigurationId: tag.tagConfigurationMetadata.tagConfigurationId,
        value: tag.tagRegistration?.tagValue || ""
      }
    })

  }
}
