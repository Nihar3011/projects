import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { DataService } from '../data.service';
import { IStudent } from '../student';
import {first} from 'rxjs/operators';
import {Router, Data} from '@angular/router';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private userService: DataService) { }

  addForm: FormGroup;

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      id: ['', Validators.required],
      rollno: ['', Validators.required],
      name: ['', Validators.required],
      name1: ['', Validators.required],
      gender: ['', Validators.required],
      mobile: ['', Validators.required]
    });
  }
  onSubmit() {console.log(this.addForm.controls['gender'].value);
    this.userService.createItem(this.addForm.value)
      .subscribe( data => {
        this.router.navigateByUrl('');
      });
  }
}
