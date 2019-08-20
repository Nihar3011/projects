import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ListstudentsComponent } from './showStudents/liststudents/liststudents.component';
import { ShowstudentComponent } from './showStudents/showstudent/showstudent.component';
import { AddstudentComponent } from './addstudent/addstudent.component'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ListstudentsComponent,
    AddstudentComponent,
    ShowstudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
