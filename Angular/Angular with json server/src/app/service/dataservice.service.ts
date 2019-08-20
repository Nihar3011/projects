import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../files/data';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { AppError} from '../files/app-error';
import { NotFoundError} from '../files/not_found_error';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataserviceService {
   id: number;
  constructor(private http: HttpClient) { }

  url = 'http://localhost:3000/students';
  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.url);

  }
addStudent(data: Student): Observable<void> {
  return this.http.post<void>(this.url, data);
}
  deleteStudent(data: Student): Observable<void> {
      this.id =  data.id;
    return this.http.delete<void>(`${this.url}/${this.id}`);
  }

  getStudentByID(id): Observable<Student> {
      return  this.http.get<Student>(`${this.url}/${id}`);
  }

  updateStudent(id: number , data: Student) {

    return this.http.put(`${this.url}/${id}`, data);
  }
}
