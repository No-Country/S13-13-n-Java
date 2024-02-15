import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChatListRoutingModule } from './chat-list-routing.module';
import { ChatListComponent } from './chat-list.component';


@NgModule({
  declarations: [
    ChatListComponent
  ],
  imports: [
    CommonModule,
    ChatListRoutingModule
  ]
})
export class ChatListModule { }
