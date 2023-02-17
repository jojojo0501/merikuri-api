package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final String code = ResponseCode.BAD_REQUEST.name();
    private final String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}
