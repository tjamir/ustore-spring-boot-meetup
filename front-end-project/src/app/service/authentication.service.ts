import { Injectable } from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable()
export class AuthenticationService{

  public token: string;
  private url = 'http://localhost:8080/api/auth/login';

  constructor(private http: HttpClient) {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;

  }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(this.url, { username: username, password: password })
      .pipe(
        map(user => {
          if (user && user.token) {
            localStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        })
      );
  }

  logout(): void {
    this.token = null;
    localStorage.removeItem('currentUser');
  }

}
