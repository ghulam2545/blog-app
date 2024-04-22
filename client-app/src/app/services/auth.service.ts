import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LocalStorageService } from './local-storage.service';

const BASE_URL = 'http://localhost:8080/api/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    private localStorage: LocalStorageService
  ) { }

  signup(data: any): Observable<any> {
    return this.http.post(`${BASE_URL}/signup`, data);
  }

  login(username: string, password: string) {
    return this.http.post(`${BASE_URL}/login`, { username, password });
  }

  logout() {
    this.localStorage.clear();
  }

  storeInfo(username: string, token: string) {
    this.localStorage.save('username', username);
    this.localStorage.save('token', token);
  }


  signingStatus() {
    return this.localStorage.get('token') !== null;
  }
}
