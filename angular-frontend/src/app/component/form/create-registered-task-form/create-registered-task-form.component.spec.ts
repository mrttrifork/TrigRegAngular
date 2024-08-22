import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRegisteredTaskFormComponent } from './create-registered-task-form.component';

describe('CreateRegisteredTaskFormComponent', () => {
  let component: CreateRegisteredTaskFormComponent;
  let fixture: ComponentFixture<CreateRegisteredTaskFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateRegisteredTaskFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateRegisteredTaskFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
