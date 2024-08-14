import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  private httpClient = inject(HttpClient);

  constructor() {
  }

  public logout(): Observable<void> {
    return this.httpClient.post<void>("/api/logout", null, {
      withCredentials: true
    });
  }
}
