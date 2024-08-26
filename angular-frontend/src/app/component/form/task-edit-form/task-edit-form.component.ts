import {Component, EventEmitter, inject, Input, OnInit, Output} from '@angular/core';
import {
  MyDayTimeRegistrations,
  TagRegistration,
  TaskAndTasklessRegistrationInterval
} from "../../../model/TaskAndTasklessRegistrationInterval";
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatError, MatFormField, MatHint, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton, MatIconButton} from "@angular/material/button";
import {DayTimeRegistrations, TimeRegistration, TimeRegistrationTag} from "../../../generated";
import DurationConverter from "../../../util/DurationConverter";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDialog} from "@angular/material/dialog";
import {AddTagDialogComponent} from "../../dialog/add-tag-dialog/add-tag-dialog.component";
import {firstValueFrom} from "rxjs/internal/firstValueFrom";
import {MatIcon} from "@angular/material/icon";
import {MatTooltip} from "@angular/material/tooltip";
import {DateTime} from "luxon";


export interface TimeRegistrationFormGroup {
  date: FormControl<string | null>;
  timeRegistration: FormControl<Partial<TimeRegistration> | null>;
  duration: FormControl<string | null>;
}

export interface TagsFormGroup {
  tags: FormControl<TimeRegistrationTag[] | null>;
  dayRegistrations: FormArray<FormGroup<TimeRegistrationFormGroup>>;
}

export type TagRegistrationFormGroup = FormArray<FormGroup<TagsFormGroup>>;

@Component({
  selector: 'app-task-edit-form',
  standalone: true,
  imports: [
    MatError,
    MatFormField,
    MatHint,
    MatInput,
    MatLabel,
    ReactiveFormsModule,
    MatButton,
    MatCheckboxModule,
    MatIcon,
    MatIconButton,
    MatTooltip
  ],
  templateUrl: './task-edit-form.component.html',
  styleUrl: './task-edit-form.component.scss'
})
export class TaskEditFormComponent implements OnInit {
  @Input({required: true}) task!: TaskAndTasklessRegistrationInterval;
  @Output() taskByTagRegistrationsOutput = new EventEmitter<TagRegistrationFormGroup>();
  tagRegistrationFormArray: FormArray<FormGroup<TagsFormGroup>> = new FormArray<FormGroup<TagsFormGroup>>([]);
  private availableTasks?: TimeRegistrationTag[];
  private dialog = inject(MatDialog);
  private formBuilder = inject(FormBuilder);

  public ngOnInit() {
    this.buildForm();
    this.taskByTagRegistrationsOutput.emit(this.tagRegistrationFormArray);
  }

  public buildForm() {
    const dailyRegistrations = this.task.dailyRegistrations || [];
    this.availableTasks = this.getAvailableTagsConfigurations(dailyRegistrations);
    const dayRegistrationsByTask = this.buildTags(dailyRegistrations);
    this.addDays(dayRegistrationsByTask);
    this.attachTimeRegistrations(dayRegistrationsByTask, dailyRegistrations);

    this.tagRegistrationFormArray = this.formBuilder.array<FormGroup<TagsFormGroup>>(dayRegistrationsByTask.map(value => {
      return this.formBuilder.group<TagsFormGroup>({
        tags: this.formBuilder.control(value.tags),
        dayRegistrations: this.formBuilder.array<FormGroup<TimeRegistrationFormGroup>>(value.dayRegistrations.map(dayRegistration => {
          const duration = dayRegistration.timeRegistration?.duration;
          const humanDuration = duration ? DurationConverter.convertToHumanDuration(duration) : null;
          return this.formBuilder.group<TimeRegistrationFormGroup>({
            date: this.formBuilder.control(dayRegistration.date),
            timeRegistration: this.formBuilder.control(dayRegistration.timeRegistration ?? this.getTimeRegistration(value.tags)),
            duration: this.formBuilder.control(humanDuration)
          })
        }))
      })
    }))
  }

  public getTaskName(): string {
    const taskByRegistration = this.task;
    if (!taskByRegistration) {
      return "-";
    }
    if (taskByRegistration.task) {
      return taskByRegistration.task.taskName
    }
    return taskByRegistration.taskDescription || "-";
  }

  public formatDanishDate(isoDate: string | null): string {
    if (!isoDate) {
      return "";
    }
    return DateTime.fromISO(isoDate).toFormat("dd/MM")
  }

  private getAvailableTagsConfigurations(dailyRegistrations: Array<DayTimeRegistrations>): TimeRegistrationTag[] {
    return dailyRegistrations.reduce<TimeRegistrationTag[]>((tagRegistrations, currentValue) => {
      for (const currentTimeRegistration of currentValue.timeRegistrations) {
        for (const currentTag of currentTimeRegistration.tags) {
          const hasTag = tagRegistrations.some(existingTag => existingTag.tagConfigurationMetadata.tagConfigurationId === currentTag.tagConfigurationMetadata.tagConfigurationId);
          if (!hasTag) {
            tagRegistrations.push(currentTag);
          }
        }
      }
      return tagRegistrations;
    }, []);
  }

  private buildTags(dailyRegistrations: Array<DayTimeRegistrations>): TagRegistration[] {
    return dailyRegistrations.reduce<TagRegistration[]>((tagRegistration, currentValue) => {
      for (const currentValueElement of currentValue.timeRegistrations) {
        const tagKey = this.getTagKey(currentValueElement.tags);
        if (!tagRegistration.some(value => value.tagKey)) {
          tagRegistration.push({
            tagKey: tagKey,
            tags: currentValueElement.tags,
            dayRegistrations: []
          });
        }
      }
      return tagRegistration;
    }, []);
  }

  private addDays(existingTags: TagRegistration[]) {
    for (const existingTag of existingTags) {
      existingTag.dayRegistrations = this.createDayRegistrations();
    }
  }

  private attachTimeRegistrations(existingTags: TagRegistration[], dailyRegistrations: Array<DayTimeRegistrations>) {
    for (const existingTag of existingTags) {
      for (const dayRegistration of existingTag.dayRegistrations) {
        const foundDayRegistration = dailyRegistrations.find(value => value.date === dayRegistration.date);
        if (foundDayRegistration) {
          for (const timeRegistration of foundDayRegistration.timeRegistrations) {
            if (this.getTagKey(timeRegistration.tags) === existingTag.tagKey) {
              dayRegistration.timeRegistration = timeRegistration;
            }
          }
        }
      }
    }
  }

  private getTagKey(tags: Array<TimeRegistrationTag>) {
    return tags.map(tag => tag.tagConfigurationMetadata.tagConfigurationId).join(", ");
  }

  public getTagNames(formGroup: FormGroup<TagsFormGroup>): string {
    const tagRegistration = formGroup.controls.tags.value;
    if (tagRegistration) {
      return tagRegistration.map(value => value.tagConfigurationMetadata.tagConfigurationName).join(", ");
    }
    return "";
  }

  private createDayRegistrations(): MyDayTimeRegistrations[] {
    return (this.task.dailyRegistrations || []).map<MyDayTimeRegistrations>(value => {
      return {
        date: value.date
      }
    })
  }

  public async showKnownTags() {
    const dialogRef = this.dialog.open<AddTagDialogComponent, TimeRegistrationTag[], TimeRegistrationTag[]>(
      AddTagDialogComponent,
      {data: this.availableTasks, width: "800px"}
    );
    const tags = await firstValueFrom(dialogRef.afterClosed());
    if (tags) {
      const formGroups = this.createDayRegistrations().map(value => {
        return this.formBuilder.group<TimeRegistrationFormGroup>({
          date: this.formBuilder.control(value.date),
          timeRegistration: this.formBuilder.control(this.getTimeRegistration(tags)),
          duration: this.formBuilder.control(null)
        });
      });
      this.tagRegistrationFormArray.push(this.formBuilder.group({
        tags: this.formBuilder.control(tags),
        dayRegistrations: this.formBuilder.array(formGroups)
      }));
    }
  }

  public removeTag(index: number) {
    this.tagRegistrationFormArray.removeAt(index);
  }

  private getTimeRegistration(tags: TimeRegistrationTag[], duration?: string): Partial<TimeRegistration> {
    return {
      tags: tags,
      duration: duration
    }
  }
}
