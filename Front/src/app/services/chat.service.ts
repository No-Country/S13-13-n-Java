import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Database } from '@angular/fire/database';

import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  chatRef: any;

  private chatListUrl = 'api/chatList';  // URL a la que se hará la petición

    private chatSeleccionadoSubject = new BehaviorSubject<string | null>(null);
      chatSeleccionado$ = this.chatSeleccionadoSubject.asObservable();

  constructor(private http: HttpClient, private database: Database) {

   }


  getChatList(): Observable<any> {
    return this.http.get<any>(this.chatListUrl);
  }



  seleccionarChat(chatId: string) {
    this.chatSeleccionadoSubject.next(chatId);
  }

}
