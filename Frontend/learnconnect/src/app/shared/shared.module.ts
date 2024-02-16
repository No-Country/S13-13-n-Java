import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AvatarComponent } from './avatar/avatar.component';
import { LoaderComponent } from './loader/loader.component';
import { SearchBoxComponent } from './search-box/search-box.component';
import { EllipsisPipe } from './ellipsis.pipe';
import { CardMessageComponent } from './card-message/card-message.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NotFoundComponent } from './not-found/not-found.component';



@NgModule({
  declarations: [
    AvatarComponent,
    LoaderComponent,
    SearchBoxComponent,
    EllipsisPipe,
    CardMessageComponent,
    SidebarComponent,
    NotFoundComponent
  ],
  exports: [
    AvatarComponent,
    LoaderComponent,
    SearchBoxComponent,
    EllipsisPipe,
    CardMessageComponent,
    SidebarComponent,
    NotFoundComponent
  ],
    imports: [
    CommonModule
  ]
})
export class SharedModule { }
