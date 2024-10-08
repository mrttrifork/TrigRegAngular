/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.trifork.trireg.server.api;

import com.trifork.trireg.server.model.ImportTimeRegistrationRequestInner;
import com.trifork.trireg.server.model.ImportTimeRegistrationResponseInner;
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
@Tag(name = "Import", description = "Tag for operations related to importing time registrations")
public interface ImportApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /import
     * Imports the given time registrations into the system
     *
     * @param importTimeRegistrationRequestInner A JSON object containing time registration information to be imported (required)
     * @return OK (status code 200)
     *         or JWT is missing or invalid (status code 401)
     *         or While acting as a gateway or proxy, this service received an invalid response from the upstream server. (status code 502)
     */
    @Operation(
        operationId = "importTimeRegistrations",
        description = "Imports the given time registrations into the system",
        tags = { "Import" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ImportTimeRegistrationResponseInner.class)))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid"),
            @ApiResponse(responseCode = "502", description = "While acting as a gateway or proxy, this service received an invalid response from the upstream server.")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/import",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<ImportTimeRegistrationResponseInner>> importTimeRegistrations(
        @Parameter(name = "ImportTimeRegistrationRequestInner", description = "A JSON object containing time registration information to be imported", required = true) @Valid @RequestBody List<@Valid ImportTimeRegistrationRequestInner> importTimeRegistrationRequestInner
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"timeRegistrationId\" : 0, \"message\" : \"message\", \"status\" : null }, { \"timeRegistrationId\" : 0, \"message\" : \"message\", \"status\" : null } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
