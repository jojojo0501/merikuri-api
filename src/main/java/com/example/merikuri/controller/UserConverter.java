package com.example.merikuri.controller;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.controller.result.LoginResult;
import com.example.merikuri.generated.model.CreatedResponse;
import com.example.merikuri.generated.model.LoginResponse;
import com.example.merikuri.generated.model.LoginResponseInfo;
import org.springframework.stereotype.Component;

/**
 * ユーザー情報を扱うConverter.
 */
@Component
public class UserConverter {

    /**
     * ユーザー作成のレスポンスを作成する.
     *
     * @param result result
     * @return レスポンス
     */
    public CreatedResponse toCreatedResponse(CreateUserResult result) {
        return new CreatedResponse()
                .code(ResponseCode.SUCCESS.name())
                .message("ユーザーを作成しました。（id＝" + result.getId() + "）");
    }

    /**
     * ログインのレスポンスを作成する.
     * @param result result
     * @return レスポンス
     */
    public LoginResponse toLoginResponse(LoginResult result) {
        return new LoginResponse()
                .code(ResponseCode.SUCCESS.name())
                .message("ログインに成功しました。")
                .info(new LoginResponseInfo()
                        .userId(result.getUser().getId())
                        .firstName(result.getUser().getFirstName())
                        .lastName(result.getUser().getLastName())
                        .age(result.getUser().getAge())
                        .address(result.getUser().getAddress())
                        .email(result.getUser().getEmail())
                );
    }
}
