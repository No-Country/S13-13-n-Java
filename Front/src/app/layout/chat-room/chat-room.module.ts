import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChatRoomRoutingModule } from './chat-room-routing.module';
import { ChatRoomComponent } from './chat-room.component';
import { ChatListModule } from '../chat-list/chat-list.module';

import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { ProfileModule } from '../profile/profile.module';
import { ColumnRightModule } from '../column-right/column-right.module';
import { ContactBookModule } from '../contact-book/contact-book.module';


@NgModule({
  declarations: [
    ChatRoomComponent
  ],
  imports: [
    CommonModule,
    ChatRoomRoutingModule,
    ChatListModule,
    ProfileModule,
    ColumnRightModule,
    ContactBookModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class ChatRoomModule { }
