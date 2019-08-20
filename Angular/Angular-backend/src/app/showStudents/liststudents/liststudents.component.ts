import { Component, OnInit } from '@angular/core';
import { Student } from '../../files/data';
import { DataserviceService } from '../../service/dataservice.service';
import { AppError } from 'src/app/files/app-error';
import { NotFoundError } from 'src/app/files/not_found_error';
import { PagerService } from '../../service/pager.service';

@Component({
  selector: 'app-liststudents',
  templateUrl: './liststudents.component.html',
  styleUrls: ['./liststudents.component.css']
})
export class ListstudentsComponent implements OnInit {

    // pager object
    pager: any = {};

    // paged items
    pagedItems: any[];
  students: any[];

  constructor(private dataserviceService: DataserviceService, private pagerservice: PagerService) {

  }

  ngOnInit() {
    this.dataserviceService.getStudents()
        .subscribe(
          (students) => {this.students = students; }, (error: AppError) => {
                throw error;
          });

  }


  delete(student: Student): void {
      this.dataserviceService.deleteStudent(student)
      .subscribe(
        (students) => { this.students = this.students.filter((x) => x !== student); },
        (error: AppError) => {
          if (error instanceof NotFoundError) {
            console.log('at 404');
             alert('Data allready delete!!');
          } else {
              throw error;
          }
        }
         );
  }

}
