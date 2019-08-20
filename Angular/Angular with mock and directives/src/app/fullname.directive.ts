import { Student } from './instudent/data';
import { Directive, HostListener, ElementRef, OnInit, ViewChild, Input } from '@angular/core';

@Directive({
  selector: '[appFullname]'
})
export class FullnameDirective  {


  constructor(private el: ElementRef) {
   }

   @HostListener('blur') online() {
    let value = this.el.nativeElement.value;
    value = value.toUpperCase();
    this.el.nativeElement.value = value;
  console.log(value);   }
}
