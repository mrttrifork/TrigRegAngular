import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatError, MatFormField, MatHint, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-create-unregistered-task-form',
  standalone: true,
  imports: [
    FormsModule,
    MatError,
    MatFormField,
    MatHint,
    MatInput,
    MatLabel,
    ReactiveFormsModule
  ],
  templateUrl: './create-unregistered-task-form.component.html',
  styleUrl: './create-unregistered-task-form.component.scss'
})
export class CreateUnregisteredTaskFormComponent implements OnInit {

  @Output() private onUnRegisteredTaskRegistered = new EventEmitter<FormControl<string | null>>();

  descriptionFormControl = new FormControl("");

  public ngOnInit(): void {
    this.onUnRegisteredTaskRegistered.emit(this.descriptionFormControl);
  }
}
