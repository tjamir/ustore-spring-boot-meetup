import { APP_BASE_HREF } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
// import { CoreModule } from './@core/core.module';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
// import { ThemeModule } from './@theme/theme.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
// import { AuthGuard } from './auth/auth-guard.service';

import { LoginComponent } from './login/login.component';
import { PagesModule } from './pages/pages.module';


const modules = [
  PagesModule
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent    
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    // AppRoutingModule,
    HttpClientModule,
    // RouterModule.forRoot(routes, { useHash: false }),
    NgbModule.forRoot(),
    // ThemeModule.forRoot(),
    // CoreModule.forRoot()
    ...modules
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
