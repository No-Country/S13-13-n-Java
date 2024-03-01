import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout.component';


const routes: Routes =[
  {
    path: '', component: LayoutComponent, children: [
      { path: '', redirectTo: 'chat-room', pathMatch: 'full' },
      { path: 'profile', loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule) },
      { path: 'register', loadChildren: () => import('./auth/register/register.module').then(m => m.RegisterModule) },
      { path: 'login', loadChildren: () => import('./auth/login/login.module').then(m => m.LoginModule) },
      { path: 'chat-room', loadChildren: () => import('./chat-room/chat-room.module').then(m => m.ChatRoomModule) },
      { path: 'chatList', loadChildren: () => import('./chat-list/chat-list.module').then(m => m.ChatListModule) },
      { path: 'column-right', loadChildren: () => import('./column-right/column-right.module').then(m => m.ColumnRightModule) },
      { path: 'contact-book', loadChildren: () => import('./contact-book/contact-book.module').then(m => m.ContactBookModule) }
    ]
  },
  { path: 'contact-connected', loadChildren: () => import('./contact-connected/contact-connected.module').then(m => m.ContactConnectedModule) },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
