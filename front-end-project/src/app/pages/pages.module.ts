import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { PagesComponent } from './pages.component';

const PAGES_COMPONENTS = [
  LoginComponent,
  PagesComponent
];

@NgModule({
  declarations: [...PAGES_COMPONENTS],
  imports: [
    CommonModule
  ]
})


export class PagesModule { }
