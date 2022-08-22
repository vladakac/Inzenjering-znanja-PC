import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsageCompatibilityComponent } from './usage-compatibility.component';

describe('UsageCompatibilityComponent', () => {
  let component: UsageCompatibilityComponent;
  let fixture: ComponentFixture<UsageCompatibilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsageCompatibilityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsageCompatibilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
