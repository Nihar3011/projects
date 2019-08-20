import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators} from '@angular/forms';
import {STUDENT, Student} from '../instudent/data';
import {Router} from '@angular/router';
@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent implements OnInit {
  studentform: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private router: Router) { }
  Student = STUDENT;
  ngOnInit() {

    this.studentform = this.formBuilder.group({
      rollno: ['', Validators.required],
      name: ['', Validators.required],
      gender: ['', Validators.required],
      mobile: ['', [Validators.required, Validators.pattern('^[0-9]*$'), Validators.minLength(10)]]
  });

    this.studentform = new FormGroup({
      RollNo: new FormControl(),
      FullName: new FormControl(),
      Gender: new FormControl(),
      Mobile: new FormControl()
    });
  }
  get f() { return this.studentform.controls; }

  onSubmit(): void {
    this.submitted = true;
    if (this.studentform.invalid) {
      return;
  }
    this.Student.push(
      { rollno : this.studentform.controls['RollNo'].value,
      name: this.studentform.controls['FullName'].value,
      gender: this.studentform.controls['Gender'].value,
      mobile: this.studentform.controls['Mobile'].value
     });

     this.router.navigate(['../instudent']);
   // console.log(this.Student.value);
    // this.Student.push({rollno:RollNo,name:FullName,gender:Gender,mobile:Mobile});
  }
}
