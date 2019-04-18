package com.finch.wrapper.infra.persistence.handler;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finch.wrapper.application.exception.BadRequestException;
import com.finch.wrapper.application.exception.errorDetails.CustomizedException;
import com.finch.wrapper.application.exception.errorDetails.ErrorDetails;
import com.finch.wrapper.application.exception.errorDetails.ResourceNotFoundDetails;
import com.finch.wrapper.application.exception.errorDetails.ValidationErrorDetails;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

/**
 *
 * @author jose.diegues
 */
@ControllerAdvice
public final class RestClientExceptionHandler {

    public RestClientExceptionHandler() {
    }

    public RestClientExceptionHandler(HttpStatusCodeException e, String api, String method) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (e.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            if (e.getResponseBodyAsString().contains("fieldMessage")) {
                ValidationErrorDetails error = objectMapper.readValue(e.getResponseBodyAsString(), ValidationErrorDetails.class);
                throw new BadRequestException(error.getField().concat(" ").concat(error.getFieldMessage()));
            } else {
                BadRequestException error = objectMapper.readValue(e.getResponseBodyAsString(), BadRequestException.class);
                throw new BadRequestException(error.getMessage());
            }
        } else {
            ErrorDetails error = objectMapper.readValue(e.getResponseBodyAsString(), ErrorDetails.class);
            throw new CustomizedException(error.getDetail(), e.getStatusCode());
        }
    }

    @ExceptionHandler(CustomizedException.class)
    public ResponseEntity<?> handleLocaleServiceException(CustomizedException customizedException) {
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(LocalDateTime.now())
                .status(customizedException.getHttpStatus().value())
                .title("Application Exception")
                .detail(customizedException.getMessage())
                .developerMessage(customizedException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails, customizedException.getHttpStatus());
    }
}
