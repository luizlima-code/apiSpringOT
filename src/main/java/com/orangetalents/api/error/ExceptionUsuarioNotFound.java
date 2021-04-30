package com.orangetalents.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionUsuarioNotFound extends RuntimeException {
    public ExceptionUsuarioNotFound(String message) {
        super(message);
    }
}
