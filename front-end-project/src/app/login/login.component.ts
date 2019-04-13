import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../service/authentication.service";
import {CredentialsModel} from "../model/Credentials.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  credentials:CredentialsModel;

  constructor(private authenticationService: AuthenticationService,private router: Router) { }

  ngOnInit() {
  }

  public login(){
    this.authenticationService.login(this.credentials.username,this.credentials.password).subscribe(value => {
      this.router.navigate(['dashboard']);
    })
  }


}
