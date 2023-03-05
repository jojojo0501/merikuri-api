package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

/**
 * クライアントエラー（400）
 */
@Getter
public class BadRequestException extends RuntimeException {

    /**
     * コード
     */
    private final ResponseCode code = ResponseCode.BAD_REQUEST;

    /**
     * メッセージ
     */
    private final String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}
