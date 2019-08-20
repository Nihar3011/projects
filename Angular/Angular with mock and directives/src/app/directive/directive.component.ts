import { Component, OnInit, Input } from '@angular/core';
import {  Student } from '../instudent/data';
@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css']
})
export class DirectiveComponent implements OnInit {

  // tslint:disable-next-line:no-input-rename
  @Input('value') value: Student;
  constructor() { }

  ngOnInit() {
    console.log(this.value);
  }

}
