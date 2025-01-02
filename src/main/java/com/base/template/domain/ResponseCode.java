package com.base.template.domain;

public enum ResponseCode {
    SUCCESS(200, "Operation successful"),
    ERROR(500, "Internal server error"),
    NOT_FOUND(404, "Resource not found"),
    UNAUTHORIZED(401, "Unauthorized access"),
    FORBIDDEN(403, "Forbidden access");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}