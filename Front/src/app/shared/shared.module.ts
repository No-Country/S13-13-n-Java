import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AvatarComponent } from './avatar/avatar.component';
import { LoaderComponent } from './loader/loader.component';
import { SearchBoxComponent } from './search-box/search-box.component';
import { EllipsisPipe } from './ellipsis.pipe';
import { CardMessageComponent } from './card-message/card-message.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { FooterComponent } from './footer/footer.component';
import { CardProfileComponent } from './card-profile/card-profile.component';
import { CardImagesComponent } from './card-images/card-images.component';




@NgModule({
  declarations: [
    AvatarComponent,
    LoaderComponent,
    SearchBoxComponent,
    EllipsisPipe,
    CardMessageComponent,
    SidebarComponent,
    NotFoundComponent,
    FooterComponent,
    CardProfileComponent,
    CardImagesComponent
  ],
  exports: [
    AvatarComponent,
    LoaderComponent,
    SearchBoxComponent,
    EllipsisPipe,
    CardMessageComponent,
    CardProfileComponent,
    CardImagesComponent,
    SidebarComponent,
    NotFoundComponent,
    FooterComponent
  ],
    imports: [
    CommonModule
  ]
})
export class SharedModule { }
