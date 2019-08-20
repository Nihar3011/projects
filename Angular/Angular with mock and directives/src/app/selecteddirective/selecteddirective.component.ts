import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-selecteddirective',
  templateUrl: './selecteddirective.component.html',
  styleUrls: ['./selecteddirective.component.css']
})
export class SelecteddirectiveComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('name') name: any;
  // tslint:disable-next-line:no-input-rename
  @Input('rollno') rollno: any;
  // tslint:disable-next-line:no-input-rename
  @Input('gender') gender: any;
  // tslint:disable-next-line:no-input-rename
  @Input('mobile') mobile: any;
  constructor() { }

  ngOnInit() {
  }

}
