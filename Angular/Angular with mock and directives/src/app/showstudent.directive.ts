
import { Component , Directive, HostListener, ElementRef, TemplateRef, ViewChild, Input, OnChanges, ViewContainerRef } from '@angular/core';
import { componentFactoryName } from '@angular/compiler';

@Directive({
  selector: '[appShowstudent]',
  exportAs: 'appShowstudent',

})


export class ShowstudentDirective implements OnChanges {


  @Input() appShowstudent: any;
  constructor(private container: ViewContainerRef , private template: TemplateRef<any> ) {

   }

    ngOnChanges() {
      console.log(this.appShowstudent);

  this.container.clear();
  this.container.createEmbeddedView(this.template,  {

   });

}
}
