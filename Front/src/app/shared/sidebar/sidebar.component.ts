import { Component } from '@angular/core';
import { ThemeService } from 'src/app/services/theme.service';
import { ViewsService } from 'src/app/services/views.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  constructor(private themeService: ThemeService, private viewService: ViewsService) {}

  toggleTheme(): void {
    const newTheme = this.themeService.currentTheme === 'light' ? 'dark' : 'light';
    this.themeService.changeTheme(newTheme);
  }
}
