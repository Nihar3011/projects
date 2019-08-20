import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {StudentService} from '../student.service';
import { InstudentComponent } from './instudent.component';

describe('InstudentComponent', () => {
  let component: InstudentComponent;
  let fixture: ComponentFixture<InstudentComponent>;
 let service: StudentService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
      service = new StudentService();
      component = new InstudentComponent(service);
    fixture = TestBed.createComponent(InstudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should set studentds and return students variable', () => {
    spyOn(service, 'getStudent').and.callFake(() => {
        return [{'rollno' : 150170107080, 'name' :  ' Nihar' , 'name1' :  ' Nihar' , 'gender' :  ' male' , 'mobile' : '9714319500'}];
    });
    component.ngOnInit();
    expect(component.getstudent.length).toBeGreaterThan(0);
  });
});
