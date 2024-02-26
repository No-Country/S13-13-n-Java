import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContactBookRoutingModule } from './contact-book-routing.module';
import { ContactBookComponent } from './contact-book.component';
import { SharedModule } from 'src/app/shared/shared.module';



@NgModule({
  declarations: [
    ContactBookComponent
  ],
  imports: [
    CommonModule,
    ContactBookRoutingModule,
    SharedModule
  ],
  exports: [
    ContactBookComponent
  ]
})
export class ContactBookModule { }
