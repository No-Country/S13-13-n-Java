import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChatRoomRoutingModule } from './chat-room-routing.module';
import { ChatRoomComponent } from './chat-room.component';
import { ChatListModule } from '../chat-list/chat-list.module';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    ChatRoomComponent
  ],
  imports: [
    CommonModule,
    ChatRoomRoutingModule,
    ChatListModule,
    SharedModule
  ]
})
export class ChatRoomModule { }