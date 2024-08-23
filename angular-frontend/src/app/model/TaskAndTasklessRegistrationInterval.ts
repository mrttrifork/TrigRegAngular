import {TasklessTimeRegistrationsInterval, TaskTimeRegistrationsInterval} from "../generated";

export type TaskAndTasklessRegistrationInterval = Partial<TaskTimeRegistrationsInterval & TasklessTimeRegistrationsInterval>;
