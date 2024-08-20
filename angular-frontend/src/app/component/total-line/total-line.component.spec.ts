import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalLineComponent } from './total-line.component';

describe('TotalLineComponent', () => {
  let component: TotalLineComponent;
  let fixture: ComponentFixture<TotalLineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TotalLineComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TotalLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
