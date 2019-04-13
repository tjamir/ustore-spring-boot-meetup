import {NgModule} from "@angular/core";
import {RestService} from "./rest.service";
import {AuthenticationService} from "./authentication.service";


@NgModule({
  providers: [
    RestService,
    AuthenticationService,

  ]
})
export class RestModule { }
