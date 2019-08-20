import { ListstudentsComponent } from './showStudents/liststudents/liststudents.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddstudentComponent } from './addstudent/addstudent.component';

const routes: Routes = [
  {path: '', redirectTo: '/liststudents', pathMatch: 'full' },
  { path: 'liststudents', component: ListstudentsComponent },
  {path: 'addstudent', component: AddstudentComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
