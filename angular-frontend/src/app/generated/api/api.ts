export * from './export.service';
import { ExportService } from './export.service';
export * from './import.service';
import { ImportService } from './import.service';
export * from './login.service';
import { LoginService } from './login.service';
export * from './tag.service';
import { TagService } from './tag.service';
export * from './task.service';
import { TaskService } from './task.service';
export * from './timeRegistration.service';
import { TimeRegistrationService } from './timeRegistration.service';
export const APIS = [ExportService, ImportService, LoginService, TagService, TaskService, TimeRegistrationService];
