import { Component, OnInit } from '@angular/core';
import {  Student } from './data';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-instudent',
  templateUrl: './instudent.component.html',
  styleUrls: ['./instudent.component.css']
})
export class InstudentComponent implements OnInit {

  students;
  selectedStudent: Student;

  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this. getstudent();
  }
  getstudent(): void {
    this.students = this.studentService.getStudent();
  }

  onSelect(student: Student): void {
    this.selectedStudent = student;
  }
  update(): void {
    this.selectedStudent = null;
  }
  delete(i): void {
    if ( window.confirm('Are you sure to delete ')) {
    console.log(i);
    // console.log(index);
      this.students.splice(i, 1);
    }
  }
}
