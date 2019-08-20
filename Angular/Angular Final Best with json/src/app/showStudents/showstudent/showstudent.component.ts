import { Student } from './../../files/data';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-showstudent',
  templateUrl: './showstudent.component.html',
  styleUrls: ['./showstudent.component.css']
})
export class ShowstudentComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('student') student: Student;
  @Output() deleteData: EventEmitter<Student> = new EventEmitter<Student>();
  constructor(private router: Router) { }

  ngOnInit() {
  }
  delete() {
    this.deleteData.emit(this.student);
  }
  edit() {
    this.router.navigate(['addstudent', {editId: this.student.id}]);
  }
}
