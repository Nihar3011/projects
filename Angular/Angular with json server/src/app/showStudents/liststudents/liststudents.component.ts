import { Component, OnInit } from '@angular/core';
import { Student } from '../../files/data';
import { DataserviceService } from '../../service/dataservice.service';
import { AppError } from 'src/app/files/app-error';
import { NotFoundError } from 'src/app/files/not_found_error';

@Component({
  selector: 'app-liststudents',
  templateUrl: './liststudents.component.html',
  styleUrls: ['./liststudents.component.css']
})
export class ListstudentsComponent implements OnInit {

  students: Student[];

  constructor(private dataserviceService: DataserviceService) {

  }

  ngOnInit() {
    this.dataserviceService.getStudents()
    .subscribe(
          (students) => {this.students = students; });
  }

  delete(student: Student): void {
      this.dataserviceService.deleteStudent(student)
      .subscribe(
        (students) => { this.students = this.students.filter((x) => x !== student); } );
  }

}
