import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddstudentComponent } from './addstudent.component';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router';

describe('AddstudentComponent', () => {
  let component: AddstudentComponent;
  let fixture: ComponentFixture<AddstudentComponent>;
  let router: Router;
   let Component1 : AddstudentComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddstudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddstudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    router = jasmine.createSpyObj('Router', ['navigate']);

    this.Component1 = new AddstudentComponent(new FormBuilder(), router);

  });

  it('should create a from with 5 controls', () => {
    expect(component.studentform.contains('RollNo')).toBe(true);
    expect(component.studentform.contains('FirstName')).toBe(true);
    expect(component.studentform.contains('LastName')).toBeTruthy();
    expect(component.studentform.contains('Gender')).toBe(true);
    expect(component.studentform.contains('Mobile')).toBe(true);
  });

  it('should make the name control requird', () => {
   const control = component.studentform.get('FirstName');
   control.setValue('');
    expect(control.valid).toBeFalsy();
  });
});
