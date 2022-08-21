import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentRecommendationComponent } from './component-recommendation.component';

describe('ComponentRecommendationComponent', () => {
  let component: ComponentRecommendationComponent;
  let fixture: ComponentFixture<ComponentRecommendationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentRecommendationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentRecommendationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
