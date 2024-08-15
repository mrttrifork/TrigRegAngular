/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.trifork.trireg.server.api;

import com.trifork.trireg.server.model.TagTimeRegistrationRequest;
import com.trifork.trireg.server.model.TagTimeRegistrationResponse;
import com.trifork.trireg.server.model.UpdateTagRegistrationRequest;
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
@Tag(name = "Tag", description = "Tag for CRUD operations related to adding tags to time registrations")
public interface TagApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /tag
     * Deletes a tag that was added to a time registration
     *
     * @param tagId The ID of the tag to delete (required)
     * @return Tag was successfully deleted (status code 200)
     *         or JWT is missing or invalid (status code 401)
     *         or The requested tag was not found and could not be deleted (status code 404)
     */
    @Operation(
        operationId = "deleteTagRegistration",
        description = "Deletes a tag that was added to a time registration",
        tags = { "Tag" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Tag was successfully deleted", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "The requested tag was not found and could not be deleted")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/tag",
        produces = { "text/plain" }
    )
    
    default ResponseEntity<String> deleteTagRegistration(
        @NotNull @Parameter(name = "tagId", description = "The ID of the tag to delete", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "tagId", required = true) Long tagId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /tag
     * Gets the tags associated with the given time registration
     *
     * @param timeRegistrationId The ID of the time registration to get tags for (required)
     * @return List of tags for the requested time registration (status code 200)
     *         or JWT is missing or invalid (status code 401)
     *         or Unable to find a time registration with the specified timeRegistrationId (status code 404)
     *         or While acting as a gateway or proxy, this service received an invalid response from the upstream server. (status code 502)
     */
    @Operation(
        operationId = "getTimeRegistrationTags",
        description = "Gets the tags associated with the given time registration",
        tags = { "Tag" },
        responses = {
            @ApiResponse(responseCode = "200", description = "List of tags for the requested time registration", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TagTimeRegistrationResponse.class)))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "Unable to find a time registration with the specified timeRegistrationId"),
            @ApiResponse(responseCode = "502", description = "While acting as a gateway or proxy, this service received an invalid response from the upstream server.")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/tag",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<TagTimeRegistrationResponse>> getTimeRegistrationTags(
        @NotNull @Parameter(name = "timeRegistrationId", description = "The ID of the time registration to get tags for", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "timeRegistrationId", required = true) Long timeRegistrationId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"tagConfigurationId\" : 0, \"tagValue\" : \"tagValue\" }, { \"tagConfigurationId\" : 0, \"tagValue\" : \"tagValue\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /tag
     * Tags a time registration with a specified tag and optional tag value
     *
     * @param tagTimeRegistrationRequest A JSON object containing tag information (required)
     * @return Tag was successfully added to the time registration (status code 200)
     *         or JWT is missing or invalid (status code 401)
     *         or Tag was not added to the time registration due to an error with the request (status code 400)
     *         or No time registration was found to tag (status code 404)
     *         or While acting as a gateway or proxy, this service received an invalid response from the upstream server. (status code 502)
     */
    @Operation(
        operationId = "tagTimeRegistration",
        description = "Tags a time registration with a specified tag and optional tag value",
        tags = { "Tag" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Tag was successfully added to the time registration", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid"),
            @ApiResponse(responseCode = "400", description = "Tag was not added to the time registration due to an error with the request"),
            @ApiResponse(responseCode = "404", description = "No time registration was found to tag"),
            @ApiResponse(responseCode = "502", description = "While acting as a gateway or proxy, this service received an invalid response from the upstream server.")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/tag",
        produces = { "text/plain" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> tagTimeRegistration(
        @Parameter(name = "TagTimeRegistrationRequest", description = "A JSON object containing tag information", required = true) @Valid @RequestBody TagTimeRegistrationRequest tagTimeRegistrationRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /tag
     * Updates a tag that was added to a time registration
     *
     * @param updateTagRegistrationRequest A JSON object containing the updated tag information (required)
     * @return Tag was successfully updated (status code 200)
     *         or The updated tag information yields an invalid tag (status code 400)
     *         or JWT is missing or invalid (status code 401)
     *         or The specified tag was not found (status code 404)
     */
    @Operation(
        operationId = "updateTagRegistration",
        description = "Updates a tag that was added to a time registration",
        tags = { "Tag" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Tag was successfully updated", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "The updated tag information yields an invalid tag"),
            @ApiResponse(responseCode = "401", description = "JWT is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "The specified tag was not found")
        },
        security = {
            @SecurityRequirement(name = "openId"),
            @SecurityRequirement(name = "basicAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/tag",
        produces = { "text/plain" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> updateTagRegistration(
        @Parameter(name = "UpdateTagRegistrationRequest", description = "A JSON object containing the updated tag information", required = true) @Valid @RequestBody UpdateTagRegistrationRequest updateTagRegistrationRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
