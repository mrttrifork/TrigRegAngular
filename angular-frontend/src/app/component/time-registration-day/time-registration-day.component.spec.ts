import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeRegistrationDayComponent } from './time-registration-day.component';

describe('TimeRegistrationDayComponent', () => {
  let component: TimeRegistrationDayComponent;
  let fixture: ComponentFixture<TimeRegistrationDayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TimeRegistrationDayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimeRegistrationDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
