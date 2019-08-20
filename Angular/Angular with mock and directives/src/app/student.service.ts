
import { Injectable } from '@angular/core';
import {  Student, STUDENT1 } from './instudent/data';

@Injectable({
  providedIn: 'root'
})

export class StudentService {

  constructor() { }

  getStudent() {
    return STUDENT1;
  }
}
