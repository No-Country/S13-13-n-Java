import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoading = true;


  constructor(private router: Router) {}

  // Simula la carga de datos (por ejemplo, después de una solicitud HTTP)
  ngOnInit() {
    setTimeout(() => {
      this.isLoading = false;
    }, 2000); // Simula una carga de 2 segundos
  }

  hasRoute(route:string){
    return this.router.url.includes(route);
  }


}
