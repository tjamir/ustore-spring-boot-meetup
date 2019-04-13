import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {adminLteConf} from './admin-lte.conf';

import {AppRoutingModule} from './app-routing.module';
import {CoreModule} from './core/core.module';

import {LayoutModule} from 'angular-admin-lte';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';


import { FileDropModule } from 'ngx-file-drop';

import { LoadingPageModule, MaterialBarModule } from 'angular-loading-page';
import { TableFoldersComponent } from './home/table-folders/table-folders.component';
import { InputFileDragDropComponent } from './home/input-file-drag-drop/input-file-drag-drop.component';
import {LoginComponent} from "./login/login.component";



@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    LayoutModule.forRoot(adminLteConf),
    LoadingPageModule, MaterialBarModule,
    FileDropModule
  ],
  declarations: [
    AppComponent,
    HomeComponent,
<<<<<<< HEAD
    TableFoldersComponent,
    InputFileDragDropComponent
=======
    LoginComponent
>>>>>>> 3ead799d31b9c05701dcc3528b8308b3888f966b
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
