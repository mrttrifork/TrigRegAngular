package com.trifork.trireg.client.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.api.*;
import com.trifork.trireg.server.service.OIDCTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Configuration
public class WSClientConfiguration {

    @Value("${time-registration.scheme}")
    private String timeRegistrationScheme;

    @Value("${time-registration.hostname}")
    private String timeRegistrationHostname;

    @Value("${time-registration.port}")
    private int timeRegistrationPortName;

    @Value("${time-registration.version}")
    private String timeRegistrationVersion;

    @Bean
    public ApiClient apiClient(OIDCTokenService oidcTokenService) {
        ApiClient apiClient = new ApiClient()
                .setScheme(timeRegistrationScheme)
                .setHost(timeRegistrationHostname)
                .setPort(timeRegistrationPortName)
                .setBasePath(timeRegistrationVersion);
        ObjectMapper objectMapper = apiClient.getObjectMapper(); // Returns copy
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        apiClient.setObjectMapper(objectMapper); // Need to set copy as original
        apiClient.setRequestInterceptor(builder -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof OidcUser) {
                OAuth2AccessToken accessToken = oidcTokenService.getAccessToken(authentication);
                if (accessToken != null) {
                    builder.header("Authorization", "Bearer " + accessToken.getTokenValue());
                }
                // TODO: Throw error if access token is null

                // The below code can be used in testing if we don't have to log in through OIDC
                // builder.header("Authorization", "Basic dGVzdDp0cmlyZWdwYXNzd29yZDE=");
            }
        });
        return apiClient;
    }

    @Bean
    public ImportApi importApi(ApiClient client) {
        return new ImportApi(client);
    }

    @Bean
    public ExportApi exportApi(ApiClient client) {
        return new ExportApi(client);
    }

    @Bean
    public TagApi tagApi(ApiClient client) {
        return new TagApi(client);
    }

    @Bean
    public TaskApi taskApi(ApiClient client) {
        return new TaskApi(client);
    }

    @Bean
    public TimeRegistrationApi timeRegistrationApi(ApiClient client) {
        return new TimeRegistrationApi(client);
    }
}
