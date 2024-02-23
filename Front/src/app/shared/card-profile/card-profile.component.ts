import { Component } from '@angular/core';
import { Profile } from 'src/app/interfaces/profile';

@Component({
  selector: 'app-card-profile',
  templateUrl: './card-profile.component.html',
  styleUrls: ['./card-profile.component.css']
})
export class CardProfileComponent {
  profile: Profile = {

    nombre: "Javi Herrera",
    estado: "Online",
    imagenPerfil: "https://i.imgur.com/75y797L.jpg",
    descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  mostrarInformacionAdicional: false,
  };

}
