package com.trifork.trireg.server.controller;

import com.trifork.trireg.server.api.LoginApi;
import com.trifork.trireg.server.util.HTTPResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LoginController implements LoginApi {
    private static final Logger log = LogManager.getLogger(LoginController.class);

    @Override
    public ResponseEntity<Void> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof OidcUser principal) {
            log.info(principal.toString());
        }
        return HTTPResponseUtil.createOKResponse();
    }
}
