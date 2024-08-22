import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateUnregisteredTaskFormComponent } from './create-unregistered-task-form.component';

describe('CreateUnregisteredTaskFormComponent', () => {
  let component: CreateUnregisteredTaskFormComponent;
  let fixture: ComponentFixture<CreateUnregisteredTaskFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateUnregisteredTaskFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateUnregisteredTaskFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
