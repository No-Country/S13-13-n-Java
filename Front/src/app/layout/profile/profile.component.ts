import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/interfaces/profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  showCard = true;
  showDetails = false;
  url = 'https://www.sololearn.com/images/tree.jpg';

  profile: Profile = {
    nombre: 'Javi Herrera',
    estado: 'Online',
    imagenPerfil: 'https://i.imgur.com/75y797L.jpg',

    descripcion:
      'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. ',
  };

  constructor() {}
  ngOnInit(): void {}

  // si muestra la card oculta los detalles y viceversa
  toggleDetails() {
    this.showDetails = !this.showDetails;
    this.showCard = false;
  }
  toggleCard() {
    this.showCard = !this.showCard;
    this.showDetails = false;
  }

  //permite subir la foto
  onselectFile(e: any) {
    if (e.target.files) {
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (event: any) => {
        this.url = event.target.result;
      };
    }
  }
}
