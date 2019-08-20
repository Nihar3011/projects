import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../files/data';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { AppError} from '../files/app-error';
import { NotFoundError} from '../files/not_found_error';
import { throwError } from 'rxjs';
import { BadInput } from '../files/bad-input';

@Injectable({
  providedIn: 'root'
})
export class DataserviceService {
   id: number;
  constructor(private http: HttpClient) { }

  url = 'http://localhost:3000/students';
  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.url)
         .pipe(map( response => {
             return response;
         }), catchError(this.handleError));
  }
addStudent(data: Student): Observable<void> {
  return this.http.post<void>(this.url, data)
        .pipe(map( response => {
            return response;
        }), catchError(this.handleError));
}
  deleteStudent(data: Student): Observable<void> {
    this.id =  data.id;
    return this.http.delete<void>(`${this.url}/${this.id}`)
         .pipe(map( response => {
            return response;
        }), catchError(this.handleError));
  }

  getStudentByID(id): Observable<Student> {
      return  this.http.get<Student>(`${this.url}/${id}`)
        .pipe(map( response => {
          return response;
      }), catchError(this.handleError));
  }

  updateStudent(id: number , data: Student) {

    return this.http.put(`${this.url}/${id}`, data)
        .pipe(map( response => {
          return response;
      }), catchError(this.handleError));
  }

  private handleError(error: Response) {
    if (error.status === 404) {
      return throwError(new NotFoundError());
    } else if (error.status === 400) {
      return throwError(new BadInput(error.json()));
    } else {
      return throwError(new AppError());
    }
  }
}
