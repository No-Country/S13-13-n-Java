import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
//import { ChatService } from '../../services/chat.service';

@Component({
  selector: 'app-chat-room',
  templateUrl: './chat-room.component.html',
  styleUrls: ['./chat-room.component.css']
})
export class ChatRoomComponent implements OnInit{
  isLoading: boolean = true;
  chatList: any;

  constructor(/* private chatService: ChatService */) {

   }

  // Simula una operación asíncrona, como cargar datos de un servidor
  ngOnInit() {
    setTimeout(() => {
      this.isLoading = false;
    }, 2000);
  }

}
