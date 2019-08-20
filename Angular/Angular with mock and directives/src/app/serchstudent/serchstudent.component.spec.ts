import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SerchstudentComponent } from './serchstudent.component';

describe('SerchstudentComponent', () => {
  let component: SerchstudentComponent;
  let fixture: ComponentFixture<SerchstudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SerchstudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SerchstudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
