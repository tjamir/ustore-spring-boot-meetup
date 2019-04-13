import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PagesModule } from './pages/pages.module';

// theme
import { RouterModule } from '@angular/router';
import { NbThemeModule } from '@nebular/theme';


const modules = [
  PagesModule
];

@NgModule({
  declarations: [
    AppComponent    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // RouterModule.forRoot([ ... ]), // Router is required by Nebular
    NbThemeModule.forRoot(),
    ...modules
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
