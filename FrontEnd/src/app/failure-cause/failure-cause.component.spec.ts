import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FailureCauseComponent } from './failure-cause.component';

describe('FailureCauseComponent', () => {
  let component: FailureCauseComponent;
  let fixture: ComponentFixture<FailureCauseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FailureCauseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FailureCauseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
