import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrls: ['./avatar.component.css']
})
export class AvatarComponent {
  @Input () size: number = 40;
  @Input () name: string = '';
  @Input () imageUrl: string = '';

  imageError: boolean = false;

  //Si se usa HttpClient
  //constructor(private http: HttpClient) {}
 // ngOnInit() {
  //  this.http.get('URL_DEL_API').subscribe((data: any) => {
  //    this.imageUrl = data.imageUrl;
 //   });
 // }

 //Si se usa WebSocket
 //constructor() {
  // Establecer conexión WebSocket con el backend
 // const socket = new WebSocket('ws://URL_DEL_WEBSOCKET');
  // Escuchar mensajes del WebSocket
//  socket.onmessage = (event) => {
 //   const data = JSON.parse(event.data);
 //   this.imageUrl = data.imageUrl;
 // };
//}


  onImageError() {
    this.imageError = true;
    console.log('La función onImageError se ha ejecutado.');
  }

}
