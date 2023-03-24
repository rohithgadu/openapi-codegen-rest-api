package com.example.demo.error;

import lombok.Getter;

@Getter
public class ServerModelNotFoundException extends Exception {
    private final int code;

    public ServerModelNotFoundException(String exceptionMsg, int code) {
        super(exceptionMsg);
        this.code = code;
    }
}
