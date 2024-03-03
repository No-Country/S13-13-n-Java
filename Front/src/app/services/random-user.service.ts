import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RandomUserService {
  private apiUrl = 'https://randomuser.me/api/';

  constructor(private http: HttpClient) { }

  getRandomUsers(quantity: number): Observable<any[]> {
    return this.http.get(`${this.apiUrl}?results=${quantity}`).pipe(
      map((response: any) => response.results)
    );
  }
}
