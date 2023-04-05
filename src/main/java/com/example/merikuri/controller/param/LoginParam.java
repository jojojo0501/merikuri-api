package com.example.merikuri.controller.param;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ログインのParam.
 */
@Getter
@AllArgsConstructor
public class LoginParam {

    /**
     * メールアドレス
     */
    private String email;

    /**
     * パスワード
     */
    private String password;
}
