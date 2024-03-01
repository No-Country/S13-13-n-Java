import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContactConnectedRoutingModule } from './contact-connected-routing.module';
import { ContactConnectedComponent } from './contact-connected.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [ContactConnectedComponent],
  imports: [CommonModule, ContactConnectedRoutingModule, SharedModule],
  exports: [ContactConnectedComponent],
})
export class ContactConnectedModule {}
