import { STUDENT1, Student } from './../instudent/data';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(students: Student[], searchText: string): any[] {
      students = STUDENT1;
    if (!students) {return []; }
    if (!searchText) {return students; }
    searchText = searchText.toLowerCase();

    return students.filter( it => {
      return it.name.includes(searchText);
    });
  }

}
