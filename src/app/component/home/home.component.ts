import {Component, effect, inject, OnInit, signal, WritableSignal} from '@angular/core';
import {OidcSecurityService} from "angular-auth-oidc-client";
import {AsyncPipe, JsonPipe} from "@angular/common";
import {TaskResponseInner, TasksService, TimeRegistrationResponse, TimeRegistrationService} from "../../generated";
import {debounceTime, firstValueFrom, map, Observable, startWith, switchMap} from "rxjs";
import {MatAutocompleteModule, MatAutocompleteSelectedEvent} from "@angular/material/autocomplete";
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from '@angular/material/input';
import {TaskLineComponent, TaskLineFormGroup} from "../task-line/task-line.component";
import {DateTime} from "luxon";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [JsonPipe, AsyncPipe, MatFormFieldModule, MatIconModule, MatInputModule, ReactiveFormsModule, MatAutocompleteModule, MatOptionModule, TaskLineComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  private readonly oidcSecurityService = inject(OidcSecurityService);
  readonly timeRegistrationService = inject(TimeRegistrationService);
  readonly tasksService = inject(TasksService);
  readonly formBuilder = inject(FormBuilder);

  configuration$ = this.oidcSecurityService.getConfiguration();

  userData$ = this.oidcSecurityService.userData$;

  tasksFormArray: FormArray<FormGroup<TaskLineFormGroup>> = new FormArray<FormGroup<TaskLineFormGroup>>([]);

  filteredTasks$: Observable<TaskResponseInner[]> | undefined;

  taskControl = new FormControl<string | TaskResponseInner>('');

  timeRegistrationSignal: WritableSignal<TimeRegistrationResponse[] | undefined> = signal(undefined);
  taskForUserSignal: WritableSignal<TaskResponseInner[] | undefined> = signal(undefined);

  private effectRef = effect(() => {
    const isAuthenticated = this.isAuthenticated();
    if (isAuthenticated) {
      this.timeRegistrationService.getTimeRegistrationsForUser().subscribe({
        next: value => {
          this.timeRegistrationSignal.set(value);
        }
      })
      this.tasksService.getTasksForUser().subscribe({
        next: value => {
          this.taskForUserSignal.set(value);
        }
      })
    }
  }, {allowSignalWrites: true})

  isAuthenticated = signal(false);


  ngOnInit(): void {
    this.oidcSecurityService.isAuthenticated$.subscribe(
      ({isAuthenticated}) => {
        this.isAuthenticated.set(isAuthenticated);
        console.warn('authenticated: ', isAuthenticated);
      }
    );
    this.filteredTasks$ = this.taskControl.valueChanges.pipe(
      debounceTime(50),
      startWith(this.tasksService.getTasksForUser()),
      switchMap(() => this.tasksService.getTasksForUser()),
      map(tasks => this.filterTasks(tasks)),
    );
  }

  public async addTimeRegistration() {
    await firstValueFrom(this.timeRegistrationService.addTimeRegistrationForUser({
      taskId: "1",
      date: "2024-05-13",
      duration: "PT1H30M"
    }));
  }

  private filterTasks(tasks: TaskResponseInner[]): TaskResponseInner[] {
    return tasks
      .filter(({taskId, name}) => {
        const taskValue = typeof this.taskControl.value === "string" ? this.taskControl.value : this.taskControl.value?.name ?? "";
        return name.includes(taskValue) || name.toLowerCase().includes(taskValue.toLowerCase());
      })
      .sort((a, b) => a.name.localeCompare(b.name));
  }

  refreshSession(): void {
    this.oidcSecurityService
      .forceRefreshSession()
      .subscribe((result) => console.log(result));
  }

  logout(): void {
    this.oidcSecurityService
      .logoff()
      .subscribe((result) => console.log(result));
  }

  logoffAndRevokeTokens(): void {
    this.oidcSecurityService
      .logoffAndRevokeTokens()
      .subscribe((result) => console.log(result));
  }

  revokeRefreshToken(): void {
    this.oidcSecurityService
      .revokeRefreshToken()
      .subscribe((result) => console.log(result));
  }

  revokeAccessToken(): void {
    this.oidcSecurityService
      .revokeAccessToken()
      .subscribe((result) => console.log(result));
  }

  public optionSelected($event: MatAutocompleteSelectedEvent) {
    const category = $event.option.value;
    if (category) {
      this.addTask(category as TaskResponseInner);
    }
  }

  private addTask(category: TaskResponseInner){
    const formGroup: FormGroup<TaskLineFormGroup> = this.formBuilder.group({
      monday: this.formBuilder.control(''),
      tuesday: this.formBuilder.control(''),
      wednesday: this.formBuilder.control(''),
      thursday: this.formBuilder.control(''),
      friday: this.formBuilder.control(''),
      saturday: this.formBuilder.control(''),
      sunday: this.formBuilder.control(''),
      taskId: category.taskId,
      taskName: category.name,
      weekNumber: DateTime.now().weekNumber
    });
    this.tasksFormArray.push(formGroup);
    this.taskControl.reset();
  }

  public getWeekRangeAsString() {
    const startOfWeek = DateTime.now().startOf("week");
    const endOfWeek = DateTime.now().endOf("week");

    return `Total for week: ${startOfWeek.weekNumber}; ${startOfWeek.toFormat("dd-MM-yyyy")} – ${endOfWeek.toFormat("dd-MM-yyyy")}`
  }
}
