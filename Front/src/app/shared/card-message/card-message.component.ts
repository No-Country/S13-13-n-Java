import { Component, Input, OnInit } from '@angular/core';
import { RandomUserService } from 'src/app/services/random-user.service';

@Component({
  selector: 'app-card-message',
  templateUrl: './card-message.component.html',
  styleUrls: ['./card-message.component.css']
})
export class CardMessageComponent{
  /* @Input() cardContent!: string;*/
  @Input() randomUser!: any;


  constructor(private randomUserService: RandomUserService) { }



}
