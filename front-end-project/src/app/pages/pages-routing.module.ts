import { NgModule, Component } from '@angular/core';
import { ExtraOptions, Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PagesComponent } from './pages.component';

const routes: Routes = [{
    path: '',
    component: PagesComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent,
      },      
    ],
  }];

const config: ExtraOptions = {
  useHash: true,
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
