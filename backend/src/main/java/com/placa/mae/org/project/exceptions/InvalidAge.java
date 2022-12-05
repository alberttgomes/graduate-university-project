package com.placa.mae.org.project.exceptions;

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
