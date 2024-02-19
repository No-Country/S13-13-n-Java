import { Component } from '@angular/core';
import { trigger, transition, animate, style, query, stagger } from '@angular/animations';

@Component({
  selector: 'app-chat-list',
  templateUrl: './chat-list.component.html',
  styleUrls: ['./chat-list.component.css'],
  animations: [
    trigger('pageAnimations', [
      transition(':enter', [
        query('.hero', [
          style({opacity: 0, transform: 'translateY(-100px)'}),
          stagger(30, [
            animate('500ms cubic-bezier(0.35, 0, 0.25, 1)',
            style({ opacity: 1, transform: 'none' }))
          ])
        ])
      ])
    ]),
    trigger('filterAnimation', [
      transition(':enter, * => 0, * => -1', []),
      transition(':increment', [
        query(':enter', [
          style({ opacity: 0, width: 0 }),
          stagger(50, [
            animate('300ms ease-out', style({ opacity: 1, width: '*' })),
          ]),
        ], { optional: true })
      ]),
      transition(':decrement', [
        query(':leave', [
          stagger(50, [
            animate('300ms ease-out', style({ opacity: 0, width: 0 })),
          ]),
        ])
      ]),
    ]),
  ]
})
export class ChatListComponent {
  messageTotal = -1;
  cardMessages: any[] = [
    { content: 'Texto del último mensaje', sender: 'Usuario 1' },
    { content: 'Texto del último mensaje', sender: 'Usuario 2' },
    { content: 'Texto del último mensaje', sender: 'Usuario 3' },
    { content: 'Texto del último mensaje', sender: 'Usuario 4' },
    { content: 'Texto del último mensaje', sender: 'Usuario 5' },
    { content: 'Texto del último mensaje', sender: 'Usuario 6' },
    { content: 'Texto del último mensaje', sender: 'Usuario 7' },
    { content: 'Texto del último mensaje', sender: 'Usuario 8' },
    { content: 'Texto del último mensaje', sender: 'Usuario 9' },
    { content: 'Texto del último mensaje', sender: 'Usuario 10' },
    { content: 'Texto del último mensaje', sender: 'Usuario 11' },
  ];


}

