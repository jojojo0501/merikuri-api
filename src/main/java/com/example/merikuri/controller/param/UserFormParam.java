package com.example.merikuri.controller.param;

import com.example.merikuri.generated.model.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー作成のParam.
 */
@Getter
@AllArgsConstructor
public class UserFormParam {

    /**
     * リクエスト
     */
    CreateUserRequest request;
}
