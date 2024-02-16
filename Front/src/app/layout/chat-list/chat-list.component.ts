import { Component } from '@angular/core';

@Component({
  selector: 'app-chat-list',
  templateUrl: './chat-list.component.html',
  styleUrls: ['./chat-list.component.css']
})
export class ChatListComponent {
  cardMessages: any[] = [
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
  ];


}

