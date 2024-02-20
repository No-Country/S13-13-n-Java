import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card-message',
  templateUrl: './card-message.component.html',
  styleUrls: ['./card-message.component.css']
})
export class CardMessageComponent {
  @Input() cardContent!: string;
  @Input() sender!: string;

  constructor() { }

}
