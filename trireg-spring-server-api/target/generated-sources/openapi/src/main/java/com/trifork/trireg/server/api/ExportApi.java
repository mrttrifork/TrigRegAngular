/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.trifork.trireg.server.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-15T11:01:35.044401800+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
@Validated
@Tag(name = "Export", description = "Tag for operations related to exporting time registrations to an external system")
public interface ExportApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /export
     * Exports time registrations for a specific time period for the user logged in
     *
     * @param start The start date of the export time interval (inclusive) (required)
     * @param end The end date of the export time interval (inclusive) (required)
     * @return OK (status code 200)
     *         or JWT is missing or invalid (status code 401)
     *         or While acting as a gateway or proxy, this service received an invalid response from the upstream server. (status code 502)
     */
    @Operation(
        operationId = "exportTimeRegistrationsForUser",
        description = "Exports time registrations for a specific time period for the user logged in",
        tags = { "Export" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
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
        value = "/export",
        produces = { "text/plain" }
    )
    
    default ResponseEntity<String> exportTimeRegistrationsForUser(
        @NotNull @Parameter(name = "start", description = "The start date of the export time interval (inclusive)", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "start", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
        @NotNull @Parameter(name = "end", description = "The end date of the export time interval (inclusive)", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "end", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
