package com.project.placa.mae.exception;

public class CreateArticleException extends RuntimeException {
    public CreateArticleException(String message) {
        super(message);
    }

    public CreateArticleException(Throwable cause) {
        super(cause);
    }

    public CreateArticleException(String message, Throwable cause) {
        super(message, cause);
    }
}
