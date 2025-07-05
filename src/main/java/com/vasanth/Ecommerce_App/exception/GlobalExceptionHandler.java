package com.vasanth.Ecommerce_App.exception;

import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleJsonParseError(HttpMessageNotReadableException ex) {
        ErrorResponse error = new ErrorResponse(
        ) {
            @Override
            public HttpStatusCode getStatusCode() {
                return null;
            }

            @Override
            public HttpHeaders getHeaders() {
                return ErrorResponse.super.getHeaders();
            }

            @Override
            public ProblemDetail getBody() {
                return null;
            }

            @Override
            public String getTypeMessageCode() {
                return ErrorResponse.super.getTypeMessageCode();
            }

            @Override
            public String getTitleMessageCode() {
                return ErrorResponse.super.getTitleMessageCode();
            }

            @Override
            public String getDetailMessageCode() {
                return ErrorResponse.super.getDetailMessageCode();
            }

            @Override
            public Object[] getDetailMessageArguments() {
                return ErrorResponse.super.getDetailMessageArguments();
            }

            @Override
            public Object[] getDetailMessageArguments(MessageSource messageSource, Locale locale) {
                return ErrorResponse.super.getDetailMessageArguments(messageSource, locale);
            }

            @Override
            public ProblemDetail updateAndGetBody(MessageSource messageSource, Locale locale) {
                return ErrorResponse.super.updateAndGetBody(messageSource, locale);
            }
        };
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
