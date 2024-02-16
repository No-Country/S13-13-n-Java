import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private chatListUrl = 'api/chatList';  // URL a la que se hará la petición

  constructor(private http: HttpClient) { }

  getChatList(): Observable<any> {
    return this.http.get<any>(this.chatListUrl);
  }
}
