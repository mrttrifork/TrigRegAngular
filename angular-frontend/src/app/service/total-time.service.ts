import {computed, effect, inject, Injectable, Signal, signal, WritableSignal} from '@angular/core';
import {OverviewPeriod, TimeRegistrationsByTaskResponse, TimeRegistrationService} from "../generated";
import {DateTime} from "luxon";
import {firstValueFrom} from "rxjs/internal/firstValueFrom";

@Injectable({
  providedIn: 'root'
})
export class TotalTimeService {

  private timeRegistrationService = inject(TimeRegistrationService);

  private dateSignal = signal(DateTime.now());
  private overviewPeriodSignal = signal(OverviewPeriod.Week);
  private extraTasksSignal: WritableSignal<number[]> = signal([]);

  private computedDateString = computed(() => {
    const date = this.dateSignal();

    const startOfWeek = date.startOf("week");
    const endOfWeek = date.endOf("week");

    return `Total for week ${startOfWeek.weekNumber} - ${startOfWeek.toFormat("dd-MM-yyyy")} to ${endOfWeek.toFormat("dd-MM-yyyy")}`
  })

  private timeRegistrationSignal: WritableSignal<TimeRegistrationsByTaskResponse> = signal({
    tasklessTimeRegistrations: [],
    taskTimeRegistrations: []
  });
  private timeRegistrationEffect = effect(async () => {
    const date = this.dateSignal();
    const overviewPeriod = this.overviewPeriodSignal();
    const extraTasks = this.extraTasksSignal();
    const value = await firstValueFrom(this.timeRegistrationService.getTaskTimeRegistrationsOverview(date.toISODate(), overviewPeriod, extraTasks))
    this.timeRegistrationSignal.set(value);
  }, {allowSignalWrites: true});

  public getTimeRegistrationSignalAsReadonly(): Signal<TimeRegistrationsByTaskResponse> {
    return this.timeRegistrationSignal.asReadonly();
  }

  public getWeekDateString(): Signal<string> {
    return this.computedDateString;
  }

  public gotoNextWeek(): void {
    this.dateSignal.update(value => value.plus({
      days: 7
    }));
  }

  public gotoPreviousWeek(): void {
    this.dateSignal.update(value => value.minus({
      days: 7
    }));
  }

  public setExtraTasks(extraTasks: number[]) {
    this.extraTasksSignal.set(extraTasks);
  }

  public patch() {
    this.timeRegistrationSignal.set({
      taskTimeRegistrations: this.timeRegistrationSignal().taskTimeRegistrations,
      tasklessTimeRegistrations: this.timeRegistrationSignal().tasklessTimeRegistrations
    })
  }
}
