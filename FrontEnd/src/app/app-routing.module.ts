import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComponentRecommendationComponent } from './component-recommendation/component-recommendation.component';

const routes: Routes = [
  {path: 'component-recommendation', component: ComponentRecommendationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
