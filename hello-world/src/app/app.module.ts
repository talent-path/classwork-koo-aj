import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TestControlComponent } from './test-control/test-control.component';
import { SubControlComponent } from './sub-control/sub-control.component';

@NgModule({
  declarations: [
    AppComponent,
    TestControlComponent,
    SubControlComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
