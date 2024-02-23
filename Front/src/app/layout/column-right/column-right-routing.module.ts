import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ColumnRightComponent } from './column-right.component';

const routes: Routes = [{ path: '', component: ColumnRightComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ColumnRightRoutingModule { }
