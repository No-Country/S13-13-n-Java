import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SidebarService {
  private currentComponentSubject = new BehaviorSubject<string>('chat-list');
  currentComponent$ = this.currentComponentSubject.asObservable();


  showComponent(component: string) {
    this.currentComponentSubject.next(component);

  }
}
