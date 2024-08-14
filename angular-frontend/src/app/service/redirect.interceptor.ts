import {HttpInterceptorFn, HttpResponse} from '@angular/common/http';
import {tap} from "rxjs";

export const redirectInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(
    tap(event => {
      console.log(event);
      if (event instanceof HttpResponse) {
        if (event.status === 303) {
          const redirectUrl = event.headers.get('Location'); // The redirect URL should be included in the Location header
          if (redirectUrl) {
            window.location.href = redirectUrl; // Opens the URL in a new window or tab
          }
        }
      }
    })
  );
};
