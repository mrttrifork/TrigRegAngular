import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociateTaskDialogComponent } from './associate-task-dialog.component';

describe('AssociateTaskDialogComponent', () => {
  let component: AssociateTaskDialogComponent;
  let fixture: ComponentFixture<AssociateTaskDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssociateTaskDialogComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssociateTaskDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
