import { NgModule } from '@angular/core';
import { ExtraOptions, Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'pages',
    loadChildren : 'app/pages/pages.module#PagesModule'
  },
  {
    path: '**',
    redirectTo: 'pages',
    pathMatch: 'full'
  }
  // {
  //   path: 'auth',
  //   loadChildren: 'app/ayt'
  // }
];

const config: ExtraOptions = {
  useHash: true,
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
