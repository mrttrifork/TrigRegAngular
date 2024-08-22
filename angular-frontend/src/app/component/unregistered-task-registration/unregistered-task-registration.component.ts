import {Component, Input} from '@angular/core';
import {TimeRegistrationDayComponent} from "../time-registration-day/time-registration-day.component";
import {TasklessTimeRegistrationsInterval} from "../../generated";

@Component({
  selector: 'app-unregistered-task-registration',
  standalone: true,
  imports: [
    TimeRegistrationDayComponent
  ],
  templateUrl: './unregistered-task-registration.component.html',
  styleUrl: './unregistered-task-registration.component.scss'
})
export class UnregisteredTaskRegistrationComponent {
  @Input({required: true}) task!: TasklessTimeRegistrationsInterval;
}
