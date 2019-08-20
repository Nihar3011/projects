import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelecteddirectiveComponent } from './selecteddirective.component';

describe('SelecteddirectiveComponent', () => {
  let component: SelecteddirectiveComponent;
  let fixture: ComponentFixture<SelecteddirectiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelecteddirectiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelecteddirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
