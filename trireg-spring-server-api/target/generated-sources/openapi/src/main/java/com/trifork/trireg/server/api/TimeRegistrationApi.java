/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.trifork.trireg.server.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import com.trifork.trireg.server.model.PeriodEnum;
import com.trifork.trireg.server.model.TimeRegistrationRequest;
import com.trifork.trireg.server.model.TimeRegistrationResponse;
import com.trifork.trireg.server.model.TimeRegistrationUpdateRequest;
import com.trifork.trireg.server.model.TimeRegistrationsByTaskResponseInner;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-19T11:41:29.305516100+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
@Validated
@Tag(name = "TimeRegistration", description = "Tag for CRUD operations related to time registrations")
public interface TimeRegistrationApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /time-registration/bulk
     * Add several time registrations for a user
     *
     * @param timeRegistrationRequest A JSON object containing a list of time registration information (required)
     * @return Created (status code 201)
     *         or Failed creating one or more time registrations - if one time registration failed, no time registration is saved (status code 400)
     *         or JWT is missing or invalid (status code 401)
     */
    @Operation(
        operationId = "addBulkTimeRegistrationForUser",
        description = "Add several time registrations for a user",
        tags = { "TimeRegistration" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Failed creating one or more time registrations - if one time registration failed, no time registration is saved", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/time-registration/bulk",
        produces = { "text/plain" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> addBulkTimeRegistrationForUser(
        @Parameter(name = "TimeRegistrationRequest", description = "A JSON object containing a list of time registration information", required = true) @Valid @RequestBody List<@Valid TimeRegistrationRequest> timeRegistrationRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /time-registration
     * Adds a time registration for a user
     *
     * @param timeRegistrationRequest A JSON object containing time registration information (required)
     * @return Created (status code 201)
     *         or JWT is missing or invalid (status code 401)
     */
    @Operation(
        operationId = "addTimeRegistrationForUser",
        description = "Adds a time registration for a user",
        tags = { "TimeRegistration" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/time-registration",
        produces = { "text/plain" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> addTimeRegistrationForUser(
        @Parameter(name = "TimeRegistrationRequest", description = "A JSON object containing time registration information", required = true) @Valid @RequestBody TimeRegistrationRequest timeRegistrationRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /time-registration
     * Deletes the specified time registration
     *
     * @param timeRegistrationId The id of the time registration to delete (required)
     * @return deleted (status code 200)
     *         or Bad delete request (status code 400)
     *         or JWT is missing or invalid (status code 401)
     *         or Time registration not found (status code 404)
     */
    @Operation(
        operationId = "deleteTimeRegistration",
        description = "Deletes the specified time registration",
        tags = { "TimeRegistration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "deleted", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad delete request", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "Time registration not found", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            })
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/time-registration",
        produces = { "text/plain" }
    )
    
    default ResponseEntity<String> deleteTimeRegistration(
        @NotNull @Parameter(name = "timeRegistrationId", description = "The id of the time registration to delete", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "timeRegistrationId", required = true) Long timeRegistrationId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /time-registration/active-task
     * Returns time registrations for a user grouped by task
     *
     * @param date The date to consider when fetching active tasks and time registrations (required)
     * @param period The time period to use when deciding in which time period tasks are considered active (optional)
     * @return List of time registrations for the user grouped by task (status code 200)
     *         or Request contains an invalid time period value (status code 400)
     *         or JWT is missing or invalid (status code 401)
     */
    @Operation(
        operationId = "getTaskTimeRegistrationsOverview",
        description = "Returns time registrations for a user grouped by task",
        tags = { "TimeRegistration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "List of time registrations for the user grouped by task", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TimeRegistrationsByTaskResponseInner.class))),
                @Content(mediaType = "text/plain", array = @ArraySchema(schema = @Schema(implementation = TimeRegistrationsByTaskResponseInner.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Request contains an invalid time period value", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)),
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/time-registration/active-task",
        produces = { "application/json", "text/plain" }
    )
    
    default ResponseEntity<List<TimeRegistrationsByTaskResponseInner>> getTaskTimeRegistrationsOverview(
        @NotNull @Parameter(name = "date", description = "The date to consider when fetching active tasks and time registrations", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        @Parameter(name = "period", description = "The time period to use when deciding in which time period tasks are considered active", in = ParameterIn.QUERY) @Valid @RequestParam(value = "period", required = false) PeriodEnum period
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"taskDescription\" : \"taskDescription\", \"taskName\" : \"taskName\", \"timeRegistrations\" : [ { \"date\" : \"2000-01-23\", \"duration\" : \"PT1H30M\", \"timeRegistrationId\" : 6, \"registered\" : 1, \"status\" : \"status\" }, { \"date\" : \"2000-01-23\", \"duration\" : \"PT1H30M\", \"timeRegistrationId\" : 6, \"registered\" : 1, \"status\" : \"status\" } ], \"taskId\" : 0 }, { \"taskDescription\" : \"taskDescription\", \"taskName\" : \"taskName\", \"timeRegistrations\" : [ { \"date\" : \"2000-01-23\", \"duration\" : \"PT1H30M\", \"timeRegistrationId\" : 6, \"registered\" : 1, \"status\" : \"status\" }, { \"date\" : \"2000-01-23\", \"duration\" : \"PT1H30M\", \"timeRegistrationId\" : 6, \"registered\" : 1, \"status\" : \"status\" } ], \"taskId\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /time-registration
     * Returns time registrations that belongs to a user
     *
     * @return List of time registrations for the user (status code 200)
     *         or JWT is missing or invalid (status code 401)
     */
    @Operation(
        operationId = "getTimeRegistrationsForUser",
        description = "Returns time registrations that belongs to a user",
        tags = { "TimeRegistration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "List of time registrations for the user", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TimeRegistrationResponse.class)))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/time-registration",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<TimeRegistrationResponse>> getTimeRegistrationsForUser(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"date\" : \"2000-01-23\", \"duration\" : \"PT1H30M\", \"timeRegistrationId\" : 0, \"registered\" : 6, \"description\" : \"description\", \"userId\" : 1, \"taskId\" : 5, \"status\" : null, \"tags\" : [ { \"tagConfigurationMetadata\" : { \"tagConfigurationDescription\" : \"tagConfigurationDescription\", \"tagConfigurationId\" : 5, \"tagConfigurationName\" : \"tagConfigurationName\", \"valueType\" : \"STRING\", \"cardinality\" : \"OPTIONAL\" }, \"tagValue\" : { \"tagId\" : 2, \"tagValue\" : \"tagValue\" } }, { \"tagConfigurationMetadata\" : { \"tagConfigurationDescription\" : \"tagConfigurationDescription\", \"tagConfigurationId\" : 5, \"tagConfigurationName\" : \"tagConfigurationName\", \"valueType\" : \"STRING\", \"cardinality\" : \"OPTIONAL\" }, \"tagValue\" : { \"tagId\" : 2, \"tagValue\" : \"tagValue\" } } ] }, { \"date\" : \"2000-01-23\", \"duration\" : \"PT1H30M\", \"timeRegistrationId\" : 0, \"registered\" : 6, \"description\" : \"description\", \"userId\" : 1, \"taskId\" : 5, \"status\" : null, \"tags\" : [ { \"tagConfigurationMetadata\" : { \"tagConfigurationDescription\" : \"tagConfigurationDescription\", \"tagConfigurationId\" : 5, \"tagConfigurationName\" : \"tagConfigurationName\", \"valueType\" : \"STRING\", \"cardinality\" : \"OPTIONAL\" }, \"tagValue\" : { \"tagId\" : 2, \"tagValue\" : \"tagValue\" } }, { \"tagConfigurationMetadata\" : { \"tagConfigurationDescription\" : \"tagConfigurationDescription\", \"tagConfigurationId\" : 5, \"tagConfigurationName\" : \"tagConfigurationName\", \"valueType\" : \"STRING\", \"cardinality\" : \"OPTIONAL\" }, \"tagValue\" : { \"tagId\" : 2, \"tagValue\" : \"tagValue\" } } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /time-registration
     * Updates the specified time registration
     *
     * @param timeRegistrationId The id of the time registration to update (required)
     * @param timeRegistrationUpdateRequest  (required)
     * @return Updated (status code 200)
     *         or Bad update request (status code 400)
     *         or JWT is missing or invalid (status code 401)
     *         or Time registration not found (status code 404)
     */
    @Operation(
        operationId = "updateTimeRegistrationForUser",
        description = "Updates the specified time registration",
        tags = { "TimeRegistration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Updated", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad update request", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "Time registration not found", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            })
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/time-registration",
        produces = { "text/plain" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> updateTimeRegistrationForUser(
        @NotNull @Parameter(name = "timeRegistrationId", description = "The id of the time registration to update", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "timeRegistrationId", required = true) Long timeRegistrationId,
        @Parameter(name = "TimeRegistrationUpdateRequest", description = "", required = true) @Valid @RequestBody TimeRegistrationUpdateRequest timeRegistrationUpdateRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
