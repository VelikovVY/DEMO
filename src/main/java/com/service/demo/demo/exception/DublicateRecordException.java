package com.service.demo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus (code = HttpStatus.CONFLICT)
public class DublicateRecordException extends RuntimeException {


    public DublicateRecordException(String message) {
        super(message);
    }

    public DublicateRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
