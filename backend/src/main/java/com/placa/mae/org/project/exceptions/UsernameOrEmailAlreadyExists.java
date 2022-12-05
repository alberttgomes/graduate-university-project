package com.placa.mae.org.project.exceptions;

public class UsernameOrEmailAlreadyExists extends RuntimeException {
    public UsernameOrEmailAlreadyExists(String message) {
        super(message);
    }

    public UsernameOrEmailAlreadyExists(Throwable cause) {
        super(cause);
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

}
