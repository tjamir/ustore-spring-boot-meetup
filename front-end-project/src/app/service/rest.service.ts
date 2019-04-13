import { Inject , Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, URLSearchParams, Response, RequestMethod, ResponseContentType } from '@angular/http';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
import {environment} from "../../environments/environment";
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class RestService {
  protected serverUrl: string;

  private readonly AUTH_TOKEN_HEADER: string = "X-AUTH-TOKEN";
  private readonly SERVER_PORT: string = "9000";

  constructor(protected http: Http, private authenticationService: AuthenticationService, private router: Router) {
    this.serverUrl = environment.api_url;
  }

  public set token(value: string){
    this.authenticationService.token = value;
  }

  public get token(){
    return this.authenticationService.token;
  }

  protected resolve(path: string): string {
    return this.serverUrl + '/' + path;
  }

  protected extract = (res: Response) => {
    let body;
    try {
      body = res.json();
    } catch(e) {
      body = {};
    }

    return body;
  }

  protected createRequestOptions(queryString: any, header: any): RequestOptions{
    var options = new RequestOptions({headers: this.createHeaderParams(header)});
    if(queryString){
      options.params = this.createSearchParams(queryString);

    }
    if(this.authenticationService.isAuthenticated){
      options.headers.append(this.AUTH_TOKEN_HEADER, this.authenticationService.token);
    }
    return options;
  }

  protected createSearchParams(urlParams: any): URLSearchParams{
    let urlSearchParams = new URLSearchParams();

    for (let key in urlParams) {
      urlSearchParams.append(key, urlParams[key]);
    }

    return urlSearchParams;
  }

  protected createHeaderParams(header: any): Headers{
    let headers = new Headers({ 'Content-Type': 'application/json' });
    for (let key in header) {
      headers.append(key, header[key]);
    }

    return headers;
  }


  public get<TResponse>(url: string, queryString?: any, data?: any,header?: any): Observable<TResponse> {
    var options = this.createRequestOptions(queryString, header);
    options.body = JSON.stringify(data || {});
    var response = this.http.get(this.resolve(url), options);
    this.authenticationService.lastRequest = new Date();
    return response.map(this.extract).catch(x => {
      if(x.status === 401){
        this.authenticationService.logout();
        this.router.navigate(['login', 'expired']);
      }
      return response;
    });
  }

  public post<TResponse>(url: string, queryString?: any, data?: any,header?: any): Observable<TResponse> {
    var options = this.createRequestOptions(queryString, header);
    var response = this.http.post(this.resolve(url), JSON.stringify(data || {}) , options);
    this.authenticationService.lastRequest = new Date();
    return response.map(this.extract).catch(x => {
      if (JSON.parse(x._body).systemCode === 495) {
        this.authenticationService.logout();
        this.router.navigate(['login']);
      } else if (x.status === 401) {
        this.authenticationService.logout();
        this.router.navigate(['login', 'expired']);
      }
      return response;
    });
  }

  public put<TResponse>(url: string, queryString?: any, data?: any,header?: any): Observable<TResponse> {
    var options = this.createRequestOptions(queryString, header);
    var response = this.http.put(this.resolve(url),JSON.stringify(data || {}), options);
    this.authenticationService.lastRequest = new Date();
    return response.map(this.extract).catch(x => {
      if(x.status === 401){
        this.authenticationService.logout();
        this.router.navigate(['login', 'expired']);
      }

      return response;
    });
  }

  public delete<TResponse>(url: string, queryString?: any, data?: any,header?: any): Observable<TResponse> {
    var options = this.createRequestOptions(queryString, header);
    options.body = JSON.stringify(data || {});
    var response = this.http.delete(this.resolve(url),  options);
    this.authenticationService.lastRequest = new Date();
    return response.map(this.extract).catch(x => {
      if(x.status === 401){
        this.authenticationService.logout();
        this.router.navigate(['login', 'expired']);
      }
      return response;
    });
  }

  public download(url: string, type: string, queryString?: any, data?: any,header?: any): Observable<any> {
    var options = this.createRequestOptions(queryString, header);
    options.responseType = ResponseContentType.Blob;
    this.authenticationService.lastRequest = new Date();
    var response = this.http.get(this.resolve(url), options);

    response.subscribe(
      data => {
        var blob: any = new Blob([data.blob()], { type: type })
        window.open(window.URL.createObjectURL(blob));
      },
      error => console.log("Error downloading the file."),
    );

    return response;
  }
}
