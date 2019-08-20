import { ErrorHandler } from '@angular/core';

export class AppErrorHandler implements ErrorHandler {
    handleError(error) {
      alert('Somthing went worng!!');
      console.log(error);
    }
}
