import { TestBed } from '@angular/core/testing';

import { ComponentRecommendationService } from './component-recommendation.service';

describe('ComponentRecommendationService', () => {
  let service: ComponentRecommendationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComponentRecommendationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
