import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from '@angular/common/http';

@Injectable()
export class RestService {
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Object[]>(environment.api_url);
  }

  getById(id: number) {
    return this.http.get<Object>(environment.api_url + '/' + id);
  }

  create(object: Object) {
    return this.http.post(environment.api_url, object);
  }

  update(object: Object) {
    return this.http.put(environment.api_url + '/' + object.id, Object);
  }

  delete(id: number) {
    return this.http.delete(environment.api_url + '/' + id);
  }
}
