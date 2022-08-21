import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComponentRecommendationComponent } from './component-recommendation/component-recommendation.component';
import { FailureCauseComponent } from './failure-cause/failure-cause.component';
import { SimilarityCheckComponent } from './similarity-check/similarity-check.component';
import { UsageCompatibilityComponent } from './usage-compatibility/usage-compatibility.component';

const routes: Routes = [
  {path: 'component-recommendation', component: ComponentRecommendationComponent},
  {path: 'usage-compatibility', component: UsageCompatibilityComponent},
  {path: 'failure-cause', component: FailureCauseComponent},
  {path: 'similarity-check', component: SimilarityCheckComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
