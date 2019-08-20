
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InstudentComponent } from './instudent/instudent.component';
import { AddstudentComponent } from './addstudent/addstudent.component';
import {FormsModule} from '@angular/forms';
import { FullnameDirective } from './fullname.directive';
import { MobileformatDirective } from './mobileformat.directive';
import { UsedirectiveComponent } from './usedirective/usedirective.component';
import { ShowstudentDirective } from './showstudent.directive';
import { DirectiveComponent } from './directive/directive.component';
import { SelecteddirectiveComponent } from './selecteddirective/selecteddirective.component';
import { FilterPipe } from './pipes/filter.pipe';
import { SerchstudentComponent } from './serchstudent/serchstudent.component';
@NgModule({
  declarations: [
    AppComponent,
    InstudentComponent,
    AddstudentComponent,
    FullnameDirective,
    MobileformatDirective,
    UsedirectiveComponent,
    ShowstudentDirective,
    DirectiveComponent,
    SelecteddirectiveComponent,
    FilterPipe,
    SerchstudentComponent ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
