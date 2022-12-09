package com.project.placa.mae.exception;

public class InvalidAge extends RuntimeException {
    public InvalidAge(String message) {
        super(message);
    }

    public InvalidAge(Throwable cause) {
        super(cause);
    }

    public InvalidAge(String message, Throwable cause) {
        super(message, cause);
    }
}
