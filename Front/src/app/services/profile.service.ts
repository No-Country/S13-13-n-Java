import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  constructor(private http: HttpClient) { }

  getData() {
    return this.http.get('https://deploylearnconnect-production.up.railway.app/swagger-ui/index.html#/contact-list-controller/obtenerContactListPorUserId');
  }
}
