import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListstudentsComponent } from './showStudents/liststudents/liststudents.component';
import { ShowstudentComponent } from './showStudents/showstudent/showstudent.component';
import { DataserviceService } from './service/dataservice.service';
import { AddstudentComponent } from './addstudent/addstudent.component';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import { AppErrorHandler } from './files/app-error-handler';
import {NgxPaginationModule} from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
@NgModule({
  declarations: [
    AppComponent,
    ShowstudentComponent,
    ListstudentsComponent,
    AddstudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule
  ],
  providers: [DataserviceService,
    {provide: ErrorHandler, useClass: AppErrorHandler}],
  bootstrap: [AppComponent]
})
export class AppModule { }
