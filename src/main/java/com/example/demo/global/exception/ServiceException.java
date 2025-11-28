package com.example.demo.global.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private String resultCode;
    private String message;

    public ServiceException(String resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
        this.message = message;
    }

}
