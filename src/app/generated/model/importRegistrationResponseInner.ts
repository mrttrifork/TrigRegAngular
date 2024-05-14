/**
 * TriReg2 API
 * An OpenAPI specification for time registrations
 *
 * The version of the OpenAPI document: 0.0.7
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface ImportRegistrationResponseInner { 
    registrationId: string;
    /**
     * Describes the status of the registration (SUCCESS, PENDING, FAILED)
     */
    status: string;
    /**
     * When status = FAILED, this will provide a description of the problem
     */
    message?: string;
}

