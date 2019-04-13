import { NgModule } from '@angular/core';
import { ExtraOptions, Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'pages',
    loadChildren : 'app/pages/pages.module#PagesModule'
  },
  {
    path: '**',
    redirectTo: 'logins',
  }
  // {
  //   path: 'auth',
  //   loadChildren: 'app/ayt'
  // }
];

// const config: ExtraOptions = {
//   useHash: true,
// };

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
