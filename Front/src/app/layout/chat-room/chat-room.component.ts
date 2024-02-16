import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ChatService } from '../../services/chat.service'; // Suponiendo que tienes un servicio de chat

@Component({
  selector: 'app-chat-room',
  templateUrl: './chat-room.component.html',
  styleUrls: ['./chat-room.component.css']
})
export class ChatRoomComponent implements OnInit{
  isLoading: boolean = true;
  chatList$: Observable<any>; // Suponiendo que chatList$ es un observable que emite una lista de chat
  chatList: any;


  constructor(private chatService: ChatService) {
    this.chatList$ = new Observable<any>();
   }

  // Simula una operación asíncrona, como cargar datos de un servidor
  ngOnInit() {
    setTimeout(() => {
      this.isLoading = false;
    }, 2000);
    
    this.chatList$ = this.chatService.getChatList(); // Suponiendo que tienes un método en tu servicio de chat que devuelve un observable
  }

}
