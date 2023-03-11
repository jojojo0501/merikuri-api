package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

/**
 * サーバーエラー（500）
 */
@Getter
public class ServerErrorException extends RuntimeException {

    /**
     * コード
     */
    private final ResponseCode code = ResponseCode.SERVER_ERROR;

    /**
     * メッセージ
     */
    private final String message;

    public ServerErrorException(String message) {
        this.message = message;
    }
}
