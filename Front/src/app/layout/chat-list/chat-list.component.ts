import { Component } from '@angular/core';
import { RandomUserService } from 'src/app/services/random-user.service';
//import { ChatService } from 'src/app/services/chat.service';

@Component({
  selector: 'app-chat-list',
  templateUrl: './chat-list.component.html',
  styleUrls: ['./chat-list.component.css'],
})
export class ChatListComponent {
   messageTotal = -1;
 /* cardMessages: any[] = [
    { content: 'Texto del último mensaje', sender: 'Usuario 1' },
    { content: 'Texto del último mensaje', sender: 'Usuario 2' },
    { content: 'Texto del último mensaje', sender: 'Usuario 3' },
    { content: 'Texto del último mensaje', sender: 'Usuario 4' },
    { content: 'Texto del último mensaje', sender: 'Usuario 5' },
    { content: 'Texto del último mensaje', sender: 'Usuario 6' },
    { content: 'Texto del último mensaje', sender: 'Usuario 7' },
    { content: 'Texto del último mensaje', sender: 'Usuario 8' },
    { content: 'Texto del último mensaje', sender: 'Usuario 9' },
    { content: 'Texto del último mensaje', sender: 'Usuario 10' },
    { content: 'Texto del último mensaje', sender: 'Usuario 11' },
  ]; */

  randomUsers: any[] = [];


constructor( private randomUserService: RandomUserService) {}
/*
abrirChat(chatId: string) {
  this.chatService.seleccionarChat(chatId);
} */

ngOnInit(): void {
  this.randomUserService.getRandomUsers(13).subscribe(users => {
    this.randomUsers = users;
  });
}
}


