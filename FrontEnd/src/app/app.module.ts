import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentRecommendationComponent } from './component-recommendation/component-recommendation.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UsageCompatibilityComponent } from './usage-compatibility/usage-compatibility.component';
import { FailureCauseComponent } from './failure-cause/failure-cause.component';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { SimilarityCheckComponent } from './similarity-check/similarity-check.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentRecommendationComponent,
    NavbarComponent,
    UsageCompatibilityComponent,
    FailureCauseComponent,
    SimilarityCheckComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
