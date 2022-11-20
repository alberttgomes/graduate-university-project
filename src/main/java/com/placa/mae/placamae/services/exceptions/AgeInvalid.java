package com.placa.mae.placamae.services.exceptions;

public class AgeInvalid extends RuntimeException {

    public AgeInvalid(String message) {
        super(message);
    }

    public AgeInvalid(Throwable cause) {
        super(cause);
    }

    public AgeInvalid(String message, Throwable cause) {
        super(message, cause);
    }
    
}
