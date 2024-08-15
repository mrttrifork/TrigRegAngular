package com.trifork.trireg.server.service;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.stereotype.Service;

@Service
public class OIDCTokenService {

    private final OAuth2AuthorizedClientService authorizedClientService;

    public OIDCTokenService(@Autowired OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @Nullable
    public OAuth2AccessToken getAccessToken (Authentication authentication) {
        OAuth2AuthorizedClient authorizedClient = this.getAuthorizedClient(authentication);
        if (authorizedClient != null) {
            return authorizedClient.getAccessToken();
        }
        return null;
    }

    @Nullable
    public OAuth2RefreshToken getRefreshToken(Authentication authentication) {
        OAuth2AuthorizedClient authorizedClient = this.getAuthorizedClient(authentication);
        if (authorizedClient != null) {
            return authorizedClient.getRefreshToken();
        }
        return null;
    }

    @Nullable
    private OAuth2AuthorizedClient getAuthorizedClient(Authentication authentication) {
        if (authentication instanceof OAuth2AuthenticationToken oauthToken) {
            String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();
            String principalName = oauthToken.getName();
            return authorizedClientService
                    .loadAuthorizedClient(clientRegistrationId, principalName);
        }
        return null;
    }
}
