package com.example.merikuri.controller.result;

import com.example.merikuri.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ログインのResult.
 */
@AllArgsConstructor
@Getter
public class LoginResult {

    /**
     * ユーザー情報
     */
    private User user;
}
