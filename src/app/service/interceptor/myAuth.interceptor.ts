import { HttpHandlerFn, HttpInterceptorFn } from '@angular/common/http';
import {inject} from "@angular/core";
import {OidcSecurityService} from "angular-auth-oidc-client";
import {switchMap} from "rxjs";

export const myAuthInterceptor: HttpInterceptorFn = (req, next: HttpHandlerFn) => {
  const oidcSecurityService = inject(OidcSecurityService);
  return oidcSecurityService.getAccessToken().pipe(
    switchMap(token => {
      if (req.url.startsWith("/")) {
        const modifiedRequest = req.clone({
          headers: req.headers.set('Authorization', 'Bearer ' + token)
        });
        return next(modifiedRequest);
      }
      return next(req);
    })
  )
}
