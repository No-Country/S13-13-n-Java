import { Component } from '@angular/core';
import { ThemeService } from 'src/app/services/theme.service';
import { SidebarService } from 'src/app/services/sidebar.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  constructor(private themeService: ThemeService, private sidebarService: SidebarService) {}

  toggleTheme(): void {
    const newTheme = this.themeService.currentTheme === 'light' ? 'dark' : 'light';
    this.themeService.changeTheme(newTheme);
  }

prueba(){
  console.log('boton prueba');
}

  showComponent1() {
    console.log('boton chat list corriendo');
    this.sidebarService.showComponent('chat-list');
  }

  showComponent2() {
    this.sidebarService.showComponent('contact-list');
  }
}
