import { Directive , HostListener, ElementRef } from '@angular/core';

@Directive({
  selector: '[appMobileformat]'
})
export class MobileformatDirective {

  @HostListener('blur') onBlur() {
   let value = this.el.nativeElement.value;
   value = '+91' + value;
    this.el.nativeElement.value = value;
  }
  constructor(private el: ElementRef) { }

}
