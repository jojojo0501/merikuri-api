package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

@Getter
public class ServerErrorException extends Exception {
    private final String code = ResponseCode.NOT_FOUND.name();
    private final String message;

    public ServerErrorException(String message) {
        this.message = message;
    }
}
