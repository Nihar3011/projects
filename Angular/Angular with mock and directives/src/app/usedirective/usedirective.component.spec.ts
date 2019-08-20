import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsedirectiveComponent } from './usedirective.component';

describe('UsedirectiveComponent', () => {
  let component: UsedirectiveComponent;
  let fixture: ComponentFixture<UsedirectiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsedirectiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsedirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
