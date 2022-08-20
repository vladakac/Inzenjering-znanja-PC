import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentRecommendationComponent } from './component-recommendation/component-recommendation.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UsageCompatibilityComponent } from './usage-compatibility/usage-compatibility.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentRecommendationComponent,
    NavbarComponent,
    UsageCompatibilityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
