package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import lombok.Getter;

/**
 * 共通エラー.
 */
@Getter
public class CheckedException extends Exception {

    /**
     * コード
     */
    private final ResponseCode code;

    /**
     * メッセージ
     */
    private final String message;

    public CheckedException(ResponseCode code,String message) {
        this.code = code;
        this.message = message;
    }
}
