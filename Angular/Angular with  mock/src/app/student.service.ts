
import { Injectable } from '@angular/core';
import {STUDENT, Student } from './instudent/data';

@Injectable({
  providedIn: 'root'
})

export class StudentService {

  constructor() { }

  getStudent(): Student[] {
    return STUDENT;
  }
}
