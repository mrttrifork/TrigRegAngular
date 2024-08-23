import {Component, inject} from '@angular/core';
import {
  CreateRegisteredTaskFormComponent
} from "../../form/create-registered-task-form/create-registered-task-form.component";
import {
  CreateUnregisteredTaskFormComponent
} from "../../form/create-unregistered-task-form/create-unregistered-task-form.component";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {TaskCreateResponseInner} from "../../../generated";

@Component({
  selector: 'app-associate-task-dialog',
  standalone: true,
  imports: [
    CreateRegisteredTaskFormComponent,
    CreateUnregisteredTaskFormComponent,
    FormsModule,
    MatButton,
    MatButtonToggle,
    MatButtonToggleGroup,
    MatDialogActions,
    MatDialogClose,
    MatDialogContent,
    MatDialogTitle,
    ReactiveFormsModule
  ],
  templateUrl: './associate-task-dialog.component.html',
  styleUrl: './associate-task-dialog.component.scss'
})
export class AssociateTaskDialogComponent {
  public dialogRef: MatDialogRef<AssociateTaskDialogComponent, number | undefined> = inject(MatDialogRef<AssociateTaskDialogComponent, number | undefined>);

  formGroup = new FormGroup<{ registeredTask?: FormControl<string | TaskCreateResponseInner | null> }>({});

  public registeredTaskRegistered(formControl: FormControl<string | TaskCreateResponseInner | null>) {
    this.formGroup.addControl("registeredTask", formControl);
  }

  public associateTask() {
    if (this.formGroup.valid) {
      this.dialogRef.close(this.getTaskId());
    }
  }

  public getTaskId(): number | undefined {
    const {registeredTask} = this.formGroup.value;
    if (typeof registeredTask !== "string") {
      return registeredTask?.taskId;
    }
    return undefined;
  }

  protected readonly frameElement = frameElement;
}
