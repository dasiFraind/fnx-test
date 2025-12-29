package com.fnx.fnxtest.exception.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User already exists"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Product not found"),
    PRODUCT_ALREADY_EXISTS_FOR_USER(HttpStatus.CONFLICT, "Product already exists for user"),
    PRODUCT_ALREADY_EXISTS(HttpStatus.CONFLICT, "Product already exists"),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

