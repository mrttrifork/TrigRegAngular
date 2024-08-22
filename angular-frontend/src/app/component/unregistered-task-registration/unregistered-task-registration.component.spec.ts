import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnregisteredTaskRegistrationComponent } from './unregistered-task-registration.component';

describe('UnregisteredTaskRegistrationComponent', () => {
  let component: UnregisteredTaskRegistrationComponent;
  let fixture: ComponentFixture<UnregisteredTaskRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UnregisteredTaskRegistrationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnregisteredTaskRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
