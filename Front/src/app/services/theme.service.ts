import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  currentTheme: string = 'light'; // Tema por defecto

  constructor() {
    this.applyTheme(this.currentTheme); // Aplicar el tema por defecto al inicializar el servicio
  }

  changeTheme(theme: string) {
    this.currentTheme = theme;
    this.applyTheme(theme);
  }

  private applyTheme(theme: string) {
    document.body.classList.remove('light-theme', 'dark-theme');
    document.body.classList.add(theme + '-theme');
  }
}
