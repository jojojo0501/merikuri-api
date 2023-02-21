package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

/**
 * サーバーエラー（500）
 */
@Getter
public class ServerErrorException extends Exception {

    /**
     * コード
     */
    private final String code = ResponseCode.NOT_FOUND.name();

    /**
     * メッセージ
     */
    private final String message;

    public ServerErrorException(String message) {
        this.message = message;
    }
}
