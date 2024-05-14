import {ApplicationConfig, importProvidersFrom} from '@angular/core';
import {provideRouter, withEnabledBlockingInitialNavigation} from '@angular/router';

import {routes} from './app.routes';
import {provideAuth} from "angular-auth-oidc-client";
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {ApiModule, Configuration, ConfigurationParameters} from "./generated";
import {myAuthInterceptor} from "./service/interceptor/myAuth.interceptor";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

export function apiConfigFactory(): Configuration {
  const params: ConfigurationParameters = {
    basePath: '/api'
  };
  return new Configuration(params);
}

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes, withEnabledBlockingInitialNavigation()),
    provideHttpClient(withInterceptors([myAuthInterceptor])),
    provideAuth({
      config: {
        authority: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/auth",
        // authWellknownEndpointUrl: "https://oidc.hosted.trifork.com/auth/realms/trifork/.well-known/openid-configuration",
        authWellknownEndpoints: {
          issuer: "https://oidc.hosted.trifork.com/auth/realms/trifork",
          authorizationEndpoint: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/auth",
          tokenEndpoint: "/oidc/token",
          introspectionEndpoint: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/token/introspect",
          checkSessionIframe: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/login-status-iframe.html",
          jwksUri: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/certs",
          userInfoEndpoint: "/oidc/userinfo",
          endSessionEndpoint: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/logout",
          parEndpoint: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/ext/par/request",
          revocationEndpoint: "https://oidc.hosted.trifork.com/auth/realms/trifork/protocol/openid-connect/revoke"
        },
        postLoginRoute: '/home',
        redirectUrl: window.location.origin,
        postLogoutRedirectUri: `${window.location.origin}/login`,
        clientId: 'tidsreg',
        scope: "openid offline_access",
        responseType: 'code',
        useRefreshToken: true,
        silentRenew: true,
        silentRenewUrl: window.location.origin + '/silent-renew.html',
        renewTimeBeforeTokenExpiresInSeconds: 60,
        silentRenewTimeoutInSeconds: 300
      }
    }),
    importProvidersFrom(ApiModule.forRoot(apiConfigFactory)), provideAnimationsAsync()
  ]
};
