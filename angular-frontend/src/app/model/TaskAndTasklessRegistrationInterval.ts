import {
  Task,
  TasklessTimeRegistrationsInterval,
  TaskTimeRegistrationsInterval,
  TimeRegistration,
  TimeRegistrationTag
} from "../generated";

export type TaskAndTasklessRegistrationInterval = Partial<TaskTimeRegistrationsInterval & TasklessTimeRegistrationsInterval>;

export interface TaskByTagRegistrations {
  task?: Task;
  taskDescription?: string;
  dayRegistrationsByTag: Array<TagRegistration>;
}

export interface TagRegistration {
  tags: Array<TimeRegistrationTag>;
  tagKey: string;
  dayRegistrations: Array<MyDayTimeRegistrations>;
}

export interface MyDayTimeRegistrations {
  date: string;
  timeRegistration?: TimeRegistration;
}
