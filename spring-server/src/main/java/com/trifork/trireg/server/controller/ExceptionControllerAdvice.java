package com.trifork.trireg.server.controller;

import com.trifork.trireg.server.model.ErrorResponse;
import com.trifork.trireg.server.util.ErrorResponses;
import com.trifork.trireg.server.util.HTTPResponseUtil;
import jakarta.validation.ConstraintViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.ws.soap.client.SoapFaultClientException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger log = LogManager.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErrorResponse> handleSecurityException(SecurityException exception) {
        log.info(exception);
        return HTTPResponseUtil.createResponse(HttpStatus.UNAUTHORIZED, ErrorResponses.UNAUTHORIZED);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> HttpClientErrorException(HttpClientErrorException exception) {
        log.info(exception);
        return HTTPResponseUtil.createResponse(exception.getStatusCode(), ErrorResponses.HTTP_CLIENT_ERROR_EXCEPTION(exception.getStatusCode(), exception.getStatusText()));
    }
    private static void appendError(Map<String, String> errors, String fieldName, String errorMessage) {
        errors.put(fieldName, errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> requestValidationException(ConstraintViolationException constraintViolationException) {
        Map<String, String> errors = new HashMap<>();
        constraintViolationException.getConstraintViolations().forEach(
                (error) ->  appendError(errors, error.getPropertyPath().toString(), error.getMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> requestValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();
        for (ObjectError error : methodArgumentNotValidException.getBindingResult().getAllErrors()) {
            appendError(errors, ((FieldError) error).getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ErrorResponse> HttpServerErrorException(HttpServerErrorException exception) {
        log.error("Got HttpServerErrorException", exception);
        return HTTPResponseUtil.createResponse(exception.getStatusCode(), ErrorResponses.HTTP_CLIENT_ERROR_EXCEPTION(exception.getStatusCode(), "Der skete en fejl"));
    }

    @ExceptionHandler(SoapFaultClientException.class)
    public ResponseEntity<ErrorResponse> handleSoapFaultClientException(SoapFaultClientException exception) {
        log.warn(exception);
        return HTTPResponseUtil.createResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorResponses.SOAP_FAULT(exception.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception) {
        log.error("Got a runtime exception", exception);
        return HTTPResponseUtil.createResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorResponses.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error("Got an unknown exception", exception);
        return HTTPResponseUtil.createResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorResponses.INTERNAL_SERVER_ERROR);
    }
}
