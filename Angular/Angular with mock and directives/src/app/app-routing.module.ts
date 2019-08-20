import { UsedirectiveComponent } from './usedirective/usedirective.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddstudentComponent } from './addstudent/addstudent.component';
import {InstudentComponent} from './instudent/instudent.component';

const routes: Routes = [
  {path: '', redirectTo: '/instudent', pathMatch: 'full' },
  { path: 'instudent', component: InstudentComponent },
  { path: 'addstudent', component: AddstudentComponent },
  { path: 'usedirective', component: UsedirectiveComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
