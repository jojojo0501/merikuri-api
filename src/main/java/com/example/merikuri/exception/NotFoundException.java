package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String code = ResponseCode.NOT_FOUND.name();
    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
