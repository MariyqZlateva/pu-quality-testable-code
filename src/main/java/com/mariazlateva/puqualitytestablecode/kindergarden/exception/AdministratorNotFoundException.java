package com.mariazlateva.puqualitytestablecode.kindergarden.exception;

public class AdministratorNotFoundException extends RuntimeException {

    public AdministratorNotFoundException() {
        super();
    }

    public AdministratorNotFoundException(String message) {
        super(message);
    }

    public AdministratorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdministratorNotFoundException(Throwable cause) {
        super(cause);
    }
}
