import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private baseUrl = 'http://localhost:8080/rest/task'; // TODO: update to real URL
  // private baseUrl = 'http://localst:808/task';

  constructor(private http: HttpClient) { }

  claimTask(id: string, value: any): Observable<any> {
    const headers = new  HttpHeaders().set('Content-Type', 'application/json');
    headers.set('Access-Control-Allow-Origin', '*');
    return this.http.post(`${this.baseUrl}/${id}/claim`, value);
  }

  // tslint:disable-next-line:ban-types
  updateTask(id: string, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${id}/complete`, value);
  }

  getTasksList(value: any): Observable<any> {
    const headers = new  HttpHeaders().set('Content-Type', 'application/json');
    headers.set('Access-Control-Allow-Origin', '*');
    return this.http.post(`${this.baseUrl}`, value);
  }
}
