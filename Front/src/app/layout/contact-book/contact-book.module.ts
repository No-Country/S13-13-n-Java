import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContactBookRoutingModule } from './contact-book-routing.module';
import { ContactBookComponent } from './contact-book.component';


@NgModule({
  declarations: [
    ContactBookComponent
  ],
  imports: [
    CommonModule,
    ContactBookRoutingModule
  ]
})
export class ContactBookModule { }
