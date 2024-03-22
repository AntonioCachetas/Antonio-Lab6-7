package org.humber.student.exceptions;

public enum ErrorCode {
    INVALID_CUSTOMER_ID("Invalid customer id"),
    INVALID_CUSTOMER_NAME("Invalid customer name");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
