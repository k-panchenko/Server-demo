package com.example.serverdemo.repository;

import com.example.serverdemo.domain.response.ErrorResponse;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ConstraintViolationControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        var cause = (ConstraintViolationException) NestedExceptionUtils.getRootCause(ex);
        var bodyOfResponse = Objects.requireNonNull(cause).getConstraintViolations().stream()
                .map(cv -> String.join(" ", cv.getPropertyPath().toString(), cv.getMessage()))
                .collect(Collectors.toList());
        return handleExceptionInternal(
                ex,
                new ErrorResponse(bodyOfResponse),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request
        );
    }
}
