import {Component, inject} from '@angular/core';
import {AsyncPipe, JsonPipe} from "@angular/common";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from '@angular/material/input';
import {MatButton, MatFabButton, MatIconButton} from "@angular/material/button";
import {TotalLineComponent} from "../total-line/total-line.component";
import {MatCardModule} from "@angular/material/card";
import {TaskRegistrationComponent} from "../task-registration/task-registration.component";
import {TotalTimeService} from "../../service/total-time.service";
import {MatDialog} from "@angular/material/dialog";
import {CreateTaskDialogComponent, TaskOrDescription} from "../dialog/create-task-dialog/create-task-dialog.component";
import {MatTabsModule} from "@angular/material/tabs";
import {MatBadge} from "@angular/material/badge";
import {MatTooltip} from "@angular/material/tooltip";
import {firstValueFrom} from "rxjs/internal/firstValueFrom";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [JsonPipe, AsyncPipe, MatFormFieldModule, MatIconModule, MatInputModule, ReactiveFormsModule, MatAutocompleteModule, MatOptionModule, MatButton, TotalLineComponent, MatCardModule, TaskRegistrationComponent, MatFabButton, MatIconButton, MatTabsModule, MatBadge, MatTooltip],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  readonly totalTimeService = inject(TotalTimeService);
  private readonly dialog = inject(MatDialog);

  public async openCreateDialog() {
    const dialogRef = this.dialog.open<CreateTaskDialogComponent, any, TaskOrDescription | undefined>(
      CreateTaskDialogComponent, {width: "800px"});
    const value = await firstValueFrom(dialogRef.afterClosed())
    if (value) {
      const extraTasks = value.taskId ? [value.taskId] : [];
      this.totalTimeService.setExtraTasks(extraTasks);
    }
  }

  public getTimeRegistrationSignalAsReadonly() {
    return this.totalTimeService.getTimeRegistrationSignalAsReadonly()();
  }

  public goToNextWeek() {
    return this.totalTimeService.gotoNextWeek();
  }

  public gotoPreviousWeek() {
    return this.totalTimeService.gotoPreviousWeek();
  }
}
