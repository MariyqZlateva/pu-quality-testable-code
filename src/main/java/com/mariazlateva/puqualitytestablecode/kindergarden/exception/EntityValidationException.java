package com.mariazlateva.puqualitytestablecode.kindergarden.exception;

public class EntityValidationException extends Exception {

    public EntityValidationException() {
        super();
    }

    public EntityValidationException(String message) {
        super(message);
    }

    public EntityValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityValidationException(Throwable cause) {
        super(cause);
    }
}
