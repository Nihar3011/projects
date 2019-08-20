import { TestBed } from '@angular/core/testing';

import { StudentService } from './student.service';

describe('StudentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be have data', () => {
    const service: StudentService = TestBed.get(StudentService);
    const result = service.getStudent();
    expect(result).toBeTruthy();
  });
});
