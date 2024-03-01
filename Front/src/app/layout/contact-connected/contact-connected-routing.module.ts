import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactConnectedComponent } from './contact-connected.component';

const routes: Routes = [{ path: '', component: ContactConnectedComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContactConnectedRoutingModule { }
