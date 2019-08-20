import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstudentComponent } from './instudent.component';

describe('InstudentComponent', () => {
  let component: InstudentComponent;
  let fixture: ComponentFixture<InstudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
