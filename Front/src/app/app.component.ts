import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


  constructor(private router: Router) {}

  // Simula la carga de datos (por ejemplo, después de una solicitud HTTP)
  ngOnInit() {
    
  }

  hasRoute(route:string){
    return this.router.url.includes(route);
  }


}
