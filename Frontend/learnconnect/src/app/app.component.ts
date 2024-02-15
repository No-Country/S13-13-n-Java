import { Component } from '@angular/core';
import { ThemeService } from './services/theme.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
 template:`
 <button (click)="changeTheme('light')">Light Theme</button>
 <button (click)="changeTheme('dark')">Dark Theme</button>
`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'learnconnect';
  constructor(private themeService: ThemeService) { }

  changeTheme(theme: string) {
    this.themeService.changeTheme(theme);
  }
}
