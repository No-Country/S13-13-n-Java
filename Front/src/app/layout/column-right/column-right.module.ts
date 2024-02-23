import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColumnRightRoutingModule } from './column-right-routing.module';
import { ColumnRightComponent } from './column-right.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ProfileModule } from '../profile/profile.module';



@NgModule({
  declarations: [
    ColumnRightComponent
  ],
  imports: [
    CommonModule,
    ColumnRightRoutingModule,
    ProfileModule,
    SharedModule
  ],
  exports: [
    ColumnRightComponent
  ]
})
export class ColumnRightModule { }
