import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASE_API = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(
    private http: HttpClient
  ) {

  }

  all(): Observable<any> {
    return this.http.get(`${BASE_API}/blogs`);
  }

  read(id: number): Observable<any> {
    return this.http.get(`${BASE_API}/blogs/${id}`);
  }

  save(data: any): Observable<any> {
    return this.http.post(`${BASE_API}/blogs`, data);
  }

  search(term: string): Observable<any> {
    return this.http.get(`${BASE_API}/blogs/search/${term}`);
  }
}
