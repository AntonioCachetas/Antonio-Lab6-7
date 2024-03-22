package org.humber.student.exceptions;

public enum ErrorCode {
    INVALID_STUDENT_ID("Invalid student id"),
    INVALID_STUDENT_NAME("Invalid student name");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
