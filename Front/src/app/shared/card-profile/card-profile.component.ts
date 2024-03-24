import { Component, Input, OnInit } from '@angular/core';
import { RandomUserService } from 'src/app/services/random-user.service';

@Component({
  selector: 'app-card-profile',
  templateUrl: './card-profile.component.html',
  styleUrls: ['./card-profile.component.css']
})
export class CardProfileComponent {
/*   profile: Profile = {

    nombre: "Javi Herrera",
    estado: "Online",
    imagenPerfil: "https://i.imgur.com/75y797L.jpg",
    descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",

  }; */



  @Input() randomUser!: any;


  constructor(private randomUserService: RandomUserService) { }



}
