/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.trifork.trireg.server.api;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-21T22:43:49.173986300+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
@Validated
@Tag(name = "Login", description = "Tag for operations related to logging into the service through a web browser")
public interface LoginApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /login
     * Redirects to OpenId login flow. Only to be used when logging into the service through a web browser
     *
     * @return Redirection to a login flow for the OpenId login provider. After completing the flow, the user will be redirected back to the application with a valid session token. (status code 302)
     */
    @Operation(
        operationId = "login",
        description = "Redirects to OpenId login flow. Only to be used when logging into the service through a web browser",
        tags = { "Login" },
        responses = {
            @ApiResponse(responseCode = "302", description = "Redirection to a login flow for the OpenId login provider. After completing the flow, the user will be redirected back to the application with a valid session token.")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/login"
    )
    
    default ResponseEntity<Void> login(
        
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
