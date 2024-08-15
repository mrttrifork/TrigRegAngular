package com.trifork.trireg.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.net.URI;

@Configuration
@EnableWebSecurity
public class OAuth2LoginSecurityConfig {

    private final ClientRegistrationRepository clientRegistrationRepository;

    public OAuth2LoginSecurityConfig(ClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        final OidcUserService triforkRegistrationUserService = new OidcUserService();
        return http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable) // FIXME: Figure out how to do this
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .oauth2Login(oauthLogin ->
                        oauthLogin.userInfoEndpoint(userInfoEndpointConfig ->
                                userInfoEndpointConfig.oidcUserService(triforkRegistrationUserService)))
                .logout(logout -> logout.logoutSuccessHandler(oidcLogoutSuccessHandler()))
                .build();
    }


    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler = new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri(String.valueOf(URI.create("http://localhost:8080")));
        return oidcLogoutSuccessHandler;
    }
}
