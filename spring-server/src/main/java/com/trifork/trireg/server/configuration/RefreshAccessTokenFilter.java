package com.trifork.trireg.server.configuration;

import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * This Filter handles the refreshToken. If the Access token is expired,
 * then the authorizedClientManager will get a new Access token by using the Refresh Token towards the authentication server.
 * If the Refresh is expired, then the user will be asked to log in to the application again.
 */
@Component
public class RefreshAccessTokenFilter extends OncePerRequestFilter {

    public static final String CLIENT_REGISTRATION_ID = "tidsreg";

    @Resource
    private OAuth2AuthorizedClientManager authorizedClientManager;

    @Resource
    private OAuth2AuthorizedClientRepository authorizedClientRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication) && authentication.getPrincipal() instanceof OidcUser) {
            validateToken(authentication, request, response);
        }

        filterChain.doFilter(request, response);
    }

    private void validateToken(Authentication auth, HttpServletRequest request, HttpServletResponse response) {
        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId(RefreshAccessTokenFilter.CLIENT_REGISTRATION_ID)
                .principal(auth)
                .attributes(attrs -> {
                    attrs.put(HttpServletRequest.class.getName(), request);
                    attrs.put(HttpServletResponse.class.getName(), response);
                })
                .build();
        try {
            authorizedClientManager.authorize(authorizeRequest);
        } catch (ClientAuthorizationException e) {
            authorizedClientRepository.removeAuthorizedClient(RefreshAccessTokenFilter.CLIENT_REGISTRATION_ID, auth, request, response);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }
}
