import {TimeRegistrationRequest, TimeRegistrationUpdateRequest} from "../generated";

export type ExtendedCreateTimeRegistration = TimeRegistrationRequest & {type: "create"};
export type ExtendedUpdateTimeRegistration = TimeRegistrationUpdateRequest & {type: "update", timeRegistrationId: number};
export type ExtendedDeleteTimeRegistration = {type: "delete", timeRegistrationId: number};



export type ExtendedTimeRegistrationCRUD = ExtendedCreateTimeRegistration | ExtendedUpdateTimeRegistration | ExtendedDeleteTimeRegistration
