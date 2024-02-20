import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChatListRoutingModule } from './chat-list-routing.module';
import { ChatListComponent } from './chat-list.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    ChatListComponent
  ],
  imports: [
    CommonModule,
    ChatListRoutingModule,
    SharedModule
  ],
  exports: [
    ChatListComponent
  ]
})
export class ChatListModule { }
