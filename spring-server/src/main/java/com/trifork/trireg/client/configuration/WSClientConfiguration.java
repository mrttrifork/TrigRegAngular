package com.trifork.trireg.client.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.api.ExportApi;
import com.trifork.trireg.client.api.ImportApi;
import com.trifork.trireg.client.api.TagApi;
import com.trifork.trireg.client.api.TimeRegistrationApi;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Configuration
public class WSClientConfiguration {

    @Nullable
    @Value("${trireg.scheme}")
    private String fmkAIScheme;

    @Nullable
    @Value("${trireg.hostname}")
    private String fmkAIHostname;

    @Value("${trireg.port}")
    private int fmkAIPortName;

    @Nullable
    @Value("${trireg.version}")
    private String fmkAIVersion;

//    @Autowired
//    OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

    @Bean
    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient()
                .setScheme(fmkAIScheme)
                .setHost(fmkAIHostname)
                .setPort(fmkAIPortName)
                .setBasePath(fmkAIVersion);
        ObjectMapper objectMapper = apiClient.getObjectMapper(); // Returns copy
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        apiClient.setObjectMapper(objectMapper); // Need to set copy as original
        apiClient.setRequestInterceptor(builder -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof OidcUser principal) {
                // String myClientRegistrationId = (oAuth2AuthorizedClientRepository.loadAuthorizedClient(myClientRegistrationId, authentication, apiClient)).client.getAccessToken().getTokenValue();;
                String tokenValue = principal.getIdToken().getTokenValue();
                builder.header("Authorization", "Bearer " + tokenValue);
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
    public TimeRegistrationApi timeRegistrationApi(ApiClient client) {
        return new TimeRegistrationApi(client);
    }
}
