import { Component, OnInit } from '@angular/core';

import {StudentService} from '../student.service';
@Component({
  selector: 'app-usedirective',
  templateUrl: './usedirective.component.html',
  styleUrls: ['./usedirective.component.css']
})
export class UsedirectiveComponent implements OnInit {
  students;
  constructor(private studentService: StudentService) { }

  ngOnInit() {

    this. getstudent();
  }
  getstudent(): void {
    this.students = this.studentService.getStudent();
  }
}
