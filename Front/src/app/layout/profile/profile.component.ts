import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/interfaces/profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent  implements OnInit{
  profile: Profile = {

    nombre: "Javi Herrera",
    estado: "Online",
    imagenPerfil: "https://i.imgur.com/75y797L.jpg",
    descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  mostrarInformacionAdicional: false,
  };

  constructor() { }
  ngOnInit(): void {

  }

mostrar(){
  this.profile.mostrarInformacionAdicional = true;
}

}
