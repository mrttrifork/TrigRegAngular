import {Component} from '@angular/core';
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {JsonPipe} from "@angular/common";

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

  monday = new FormControl("1");
  tuesday = new FormControl("6");
  wednesday = new FormControl("1");
  thursday = new FormControl();
  friday = new FormControl();
  saturday = new FormControl("4");
  sunday = new FormControl();
}
