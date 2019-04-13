import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



// import { LoginComponent } from './login/login.component';
import { PagesComponent } from './pages.component';
import { PagesRoutingModule } from './pages-routing.module';

const PAGES_COMPONENTS = [
  PagesComponent
];

const PAGES_MODULES = [
  
];

@NgModule({
  declarations: [...PAGES_COMPONENTS],
  imports: [
    CommonModule,
    // PagesRoutingModule,
    // ...PAGES_MODULES
  ]
})


export class PagesModule { }
