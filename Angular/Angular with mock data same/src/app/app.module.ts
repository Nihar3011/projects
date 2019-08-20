import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InstudentComponent } from './instudent/instudent.component';
import { AddstudentComponent } from './addstudent/addstudent.component';
import {FormsModule} from '@angular/forms';
import { StudentService } from './student.service';
@NgModule({
  declarations: [
    AppComponent,
    InstudentComponent,
    AddstudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
