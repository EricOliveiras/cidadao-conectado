package com.cidadao.conectado.config.error;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    public HttpStatus status;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}