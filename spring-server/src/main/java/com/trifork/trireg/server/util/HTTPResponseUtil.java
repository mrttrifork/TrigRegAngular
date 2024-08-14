package com.trifork.trireg.server.util;

import com.trifork.trireg.server.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class HTTPResponseUtil {
    public static ResponseEntity<ErrorResponse> createResponse(HttpStatusCode status, ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, status);
    }

    public static ResponseEntity<Void> createOKResponse() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> createOKResponse(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
