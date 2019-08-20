import { Student } from './../files/data';
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { DataserviceService } from '../service/dataservice.service';
import { Router , ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent implements OnInit {
  id: number;
  studentform: FormGroup;
  submitted = false;
  constructor(
    private route: ActivatedRoute,
    private router: Router ,
    private formBuilder: FormBuilder,
    private dataserviceService: DataserviceService) { }

  get f() { return this.studentform.controls; }

  ngOnInit() {

  this.studentform = this.formBuilder.group({
    rollno: ['', Validators.required],
    name: ['', Validators.required],
    name1: ['', Validators.required],
    gender: ['', Validators.required],
    mobile: ['', Validators.required]
});
    this.forEdit();
  }

  forEdit() {
    this.route.paramMap.subscribe(params => {
      this.id = Number(params.get('editId'));
        console.log( this.id);
    });
    if ( this.id !== 0) {
    this.dataserviceService.getStudentByID(this.id).subscribe(data => {
     this.studentform.patchValue(data) ;

  });  }
}

  onSubmit() {
    this.submitted = true;
    if (this.studentform.invalid) {
      return;
  }
    if (this.id !== 0) {
      console.log(this.id);
            this.dataserviceService.updateStudent(this.id, this.studentform.value)
            .subscribe(data => {
              this.router.navigateByUrl(''); } );
    } else {
            this.dataserviceService.addStudent(this.studentform.value)
            .subscribe(data => {
              this.router.navigateByUrl('');
             });
      }
    }
  }

