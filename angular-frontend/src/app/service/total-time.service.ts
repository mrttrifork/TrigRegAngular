import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {DayTimeRegistrations, TimeRegistration, TimeRegistrationsByTaskResponse} from "../generated";

@Injectable({
  providedIn: 'root'
})
export class TotalTimeService {

  private subject = new BehaviorSubject<TimeRegistrationsByTaskResponse>({
    taskTimeRegistrations: [],
    tasklessTimeRegistrations: []
  });

  constructor() {
  }

  public getObservable(): Observable<TimeRegistrationsByTaskResponse> {
    return this.subject.asObservable();
  }

  public next(value: TimeRegistrationsByTaskResponse) {
    this.subject.next(value);
  }

  public patch() {
    this.subject.next({
      taskTimeRegistrations: this.subject.value.taskTimeRegistrations,
      tasklessTimeRegistrations: this.subject.value.tasklessTimeRegistrations,
    })
  }
}
