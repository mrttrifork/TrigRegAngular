package com.trifork.trireg.server.util;

import com.trifork.trireg.server.model.ErrorResponse;
import org.springframework.http.HttpStatusCode;

/**
 * Internal HTTPCodes follow the same structure as HTTPStatus except, they use 5xxx instead of 5xx
 * Example: InternalServerError=5xx, InternalServerCode=5xxx
 */
public class ErrorResponses {
    public static final ErrorResponse UNAUTHORIZED = new ErrorResponse(4010, "Ingen adgang");
    public static final ErrorResponse INTERNAL_SERVER_ERROR = new ErrorResponse(5000, "Intern server fejl");

    public static ErrorResponse SOAP_FAULT(String message) {
        return new ErrorResponse(5001, message);
    }

    public static ErrorResponse HTTP_CLIENT_ERROR_EXCEPTION(HttpStatusCode statusCode, String message) {
        int value = statusCode.value();
        int code = (value * 10) + 1;
        return new ErrorResponse(code, message);
    }
}
