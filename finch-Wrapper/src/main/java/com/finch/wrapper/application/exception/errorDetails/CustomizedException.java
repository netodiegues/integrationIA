package com.finch.wrapper.application.exception.errorDetails;

import org.springframework.http.HttpStatus;

/**
 *
 * @author jose.diegues
 */
public class CustomizedException extends RuntimeException {

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public CustomizedException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
