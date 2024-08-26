import {Component, computed, inject, Signal, signal, WritableSignal} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef, MatDialogTitle
} from "@angular/material/dialog";
import {TimeRegistrationTag} from "../../../generated";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {
  CreateRegisteredTaskFormComponent
} from "../../form/create-registered-task-form/create-registered-task-form.component";
import {
  CreateUnregisteredTaskFormComponent
} from "../../form/create-unregistered-task-form/create-unregistered-task-form.component";
import {MatButton} from "@angular/material/button";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {ReactiveFormsModule} from "@angular/forms";

export interface TagCheckbox {
  reference?: TimeRegistrationTag;
  name: string;
  completed: boolean;
  subtasks: TagCheckbox[];
}

@Component({
  selector: 'app-add-tag-dialog',
  standalone: true,
  imports: [
    MatCheckboxModule,
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
  templateUrl: './add-tag-dialog.component.html',
  styleUrl: './add-tag-dialog.component.scss'
})
export class AddTagDialogComponent {
  tags: TimeRegistrationTag[] = inject(MAT_DIALOG_DATA);
  public dialogRef: MatDialogRef<AddTagDialogComponent, TimeRegistrationTag[]> = inject(MatDialogRef<AddTagDialogComponent, TimeRegistrationTag[]>);
  taskSignal: WritableSignal<TagCheckbox> = signal({
    name: "Check all",
    completed: false,
    subtasks: this.tags.map(value => {
      return {
        reference: value,
        name: value.tagConfigurationMetadata.tagConfigurationName,
        completed: false,
        subtasks: []
      }
    })
  });

  partiallyComplete: Signal<boolean> = computed(() => {
    const task = this.taskSignal();
    if (!task.subtasks) {
      return false;
    }
    return task.subtasks.some((checkbox: TagCheckbox) => checkbox.completed) && !task.subtasks.every(checkbox => checkbox.completed);
  });

  update(completed: boolean, index?: number) {
    this.taskSignal.update(task => {
      if (index === undefined) {
        task.completed = completed;
        for (const subtask of task.subtasks) {
          subtask.completed = completed;
        }
      } else {
        task.subtasks[index].completed = completed;
        task.completed = task.subtasks.every(checkbox => checkbox.completed) ?? true;
      }
      return {...task};
    });
  }

  public submit() {
    const tagCheckbox = this.taskSignal();
    const selected = tagCheckbox.subtasks
      .filter(checkbox => checkbox.completed)
      .map(checkbox => checkbox.reference)
      .filter(Boolean);
    this.dialogRef.close(selected as TimeRegistrationTag[]);
  }
}
