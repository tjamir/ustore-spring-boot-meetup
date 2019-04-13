import { Injectable } from "@angular/core";

@Injectable()
export class AuthenticationService{

  private readonly TOKEN = 'token';
  private readonly LAST_REQUEST = 'last_request';
  private readonly EXPIRE_SESSION_TIME: number = 1000 * 60 * 30; //Tempo em milisegundo. (30 minutos)

  public set token(value: string){
    localStorage.setItem(this.TOKEN, value)
  }

  public get token(): string{
    return localStorage.getItem(this.TOKEN);
  }

  public set lastRequest(value: Date){
    localStorage.setItem(this.LAST_REQUEST, value.toString())
  }

  public get lastRequest(): Date{
    return new Date(localStorage.getItem(this.LAST_REQUEST));
  }

  public get isAuthenticated(): boolean{
    var now = new Date();
    if(this.token){
      if(this.lastRequest){
        if(now.getTime() - this.lastRequest.getTime() <= this.EXPIRE_SESSION_TIME){
          return true;
        }
      }
    }
    this.logout(); //Limpa todos os metadados relacionados ao login do Local Storage.
    return false;
  }

  public login(authToken: string){
    this.token = authToken;
    this.lastRequest = new Date();
  }

  public logout(){
    localStorage.removeItem(this.LAST_REQUEST);
    localStorage.removeItem(this.TOKEN);
  }

}
