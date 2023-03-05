package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

/**
 * サーバーエラー（400）
 */
@Getter
public class NotFoundException extends RuntimeException {

    /**
     * コード
     */
    private final ResponseCode code = ResponseCode.NOT_FOUND;

    /**
     * メッセージ
     */
    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
