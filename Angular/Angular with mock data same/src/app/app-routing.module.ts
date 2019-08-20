import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddstudentComponent } from './addstudent/addstudent.component';
import {InstudentComponent} from './instudent/instudent.component';

const routes: Routes = [
  {path: '', redirectTo: '/instudent', pathMatch: 'full' },
  { path: 'instudent', component: InstudentComponent },
  { path: 'addstudent', component: AddstudentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
