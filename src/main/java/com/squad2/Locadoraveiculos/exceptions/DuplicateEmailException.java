package com.squad2.Locadoraveiculos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateEmailException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicateEmailException(String msg) {
        super(msg);
    }
}
