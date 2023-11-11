package com.ppj.acl.config.handler;


import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.exception.CustomHttpMessageNotReadableException;
import com.ppj.acl.config.exception.GenericException;
import com.ppj.acl.adapter.rest.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Slf4j
@ControllerAdvice
public class ErrorHandler {
    private static final String DEVELOP_PROFILE = "dev";
    private static final String LOCAL_PROFILE = "local";
    private final HttpServletRequest request;

    @Value("${spring.profiles.active:}")
    private String profile;

    public ErrorHandler(final HttpServletRequest request) {
        this.request = request;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handle(Throwable e) {
        log.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e);
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR,e, ErrorCodeAccount.INTERNAL_ERROR);
    }
    @ExceptionHandler({NonTargetRestClientException.class, RestClientGenericException.class})
    public ResponseEntity<ErrorResponse> handle(NonTargetRestClientException e) {
        log.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e);
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR,e,e.getCode());
    }
    @ExceptionHandler({NotFoundRestClientException.class, EmptyOrNullBodyRestClientException.class})
    public ResponseEntity<ErrorResponse> handle(GenericException e) {
        log.error(HttpStatus.NOT_FOUND.getReasonPhrase(), e);
        return buildError(HttpStatus.NOT_FOUND,e,e.getCode());
    }
    @ExceptionHandler({BadRequestRestClientException.class})
    public ResponseEntity<ErrorResponse> handle(BadRequestRestClientException e) {
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase(), e);
        return buildError(HttpStatus.BAD_REQUEST,e,e.getCode());
    }

@ExceptionHandler({TimeoutRestClientException.class})
    public ResponseEntity<ErrorResponse> handle(TimeoutRestClientException e) {
        log.error(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase(), e);
        return buildError(HttpStatus.REQUEST_TIMEOUT,e,e.getCode());
    }

    @ExceptionHandler(CustomHttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleCustomHttpMessageNotReadableException(CustomHttpMessageNotReadableException ex) {
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);

        final var isDebugMessage = DEVELOP_PROFILE.equals(profile) || LOCAL_PROFILE.equals(profile) ? Arrays.toString(ex.getStackTrace()) : "";
        final var queryString = Optional.ofNullable(request.getQueryString()).orElse("");
        final var metaData = Map.of(
                "query_string", queryString,
                "stack_trace", isDebugMessage);

        return buildError(HttpStatus.BAD_REQUEST,ex,ErrorCodeAccount.CARD_INVALID_REQUEST);
    }

    private ResponseEntity<ErrorResponse> buildError(HttpStatus httpStatus, Throwable e, ErrorCodeAccount code) {
        final var isDebugMessage = DEVELOP_PROFILE.equals(profile) || LOCAL_PROFILE.equals(profile) ? Arrays.toString(e.getStackTrace()) : "";
        final var queryString = Optional.ofNullable(request.getQueryString()).orElse("");
        final var metaData = Map.of(
                "query_string", queryString,
                "stack_trace", isDebugMessage);
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .name(httpStatus.getReasonPhrase())
                        .detail(String.format("%s: %s", e.getClass().getCanonicalName(), e.getMessage()))
                        .status(httpStatus.value())
                        .code(code.getValue())
                        .resource(request.getRequestURI())
                        .metadata(metaData)
                        .build(), httpStatus);

    }
}
