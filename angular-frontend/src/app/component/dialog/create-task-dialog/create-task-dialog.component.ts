import {Component, effect, inject} from '@angular/core';
import {MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {
  CreateRegisteredTaskFormComponent
} from "../../form/create-registered-task-form/create-registered-task-form.component";
import {
  CreateUnregisteredTaskFormComponent
} from "../../form/create-unregistered-task-form/create-unregistered-task-form.component";
import {TaskCreateResponseInner, TimeRegistrationRequest} from "../../../generated";
import {DateTime} from "luxon";
import {toSignal} from "@angular/core/rxjs-interop";

interface TaskAndTasklessFormGroup {
  unRegisteredTask?: FormControl<string | null>;
  registeredTask?: FormControl<string | TaskCreateResponseInner | null>;
}

export type TaskOrDescription = Pick<TimeRegistrationRequest, "taskId" | "description">

@Component({
  selector: 'app-create-task-dialog',
  standalone: true,
  imports: [
    MatDialogModule,
    MatButtonModule,
    MatButtonToggleModule,
    ReactiveFormsModule,
    CreateRegisteredTaskFormComponent,
    CreateUnregisteredTaskFormComponent
  ],
  templateUrl: './create-task-dialog.component.html',
  styleUrl: './create-task-dialog.component.scss'
})
export class CreateTaskDialogComponent {
  taskToggleButtonControl = new FormControl<string>("registered");

  private taskToggleButtonValueChangeSignal = toSignal(this.taskToggleButtonControl.valueChanges);

  private useEffect = effect(() => {
    const toggleButtonValue = this.taskToggleButtonValueChangeSignal();
    if (toggleButtonValue) {
      switch (toggleButtonValue) {
        case "registered":
          this.formGroup.controls.registeredTask?.enable();
          this.formGroup.controls.unRegisteredTask?.disable();
          break;
        case "unregistered":
          this.formGroup.controls.registeredTask?.disable();
          this.formGroup.controls.unRegisteredTask?.enable();
          break;
      }
    }
  });

  public dialogRef: MatDialogRef<CreateTaskDialogComponent, TaskOrDescription | undefined> = inject(MatDialogRef<CreateTaskDialogComponent, TaskOrDescription | undefined>);

  formGroup = new FormGroup<TaskAndTasklessFormGroup>({});

  public unRegisteredTaskRegistered(formControl: FormControl<string | null>) {
    this.formGroup.addControl("unRegisteredTask", formControl);
  }

  public registeredTaskRegistered(formControl: FormControl<string | TaskCreateResponseInner | null>) {
    this.formGroup.addControl("registeredTask", formControl);
  }

  public createTask() {
    if (this.formGroup.valid) {
      this.dialogRef.close(this.getTimeRegistrationRequest());
    }
  }

  public getTimeRegistrationRequest(): TaskOrDescription {
    const {registeredTask, unRegisteredTask} = this.formGroup.value;
    return {
      description: unRegisteredTask || undefined,
      taskId: typeof registeredTask === "string" ? undefined : registeredTask?.taskId
    }
  }
}
