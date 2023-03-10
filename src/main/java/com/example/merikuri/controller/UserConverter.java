package com.example.merikuri.controller;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.generated.model.CreatedResponse;

/**
 * ユーザー情報を扱うConverter.
 */
public class UserConverter {

    /**
     * ユーザー作成のレスポンスを作成する.
     *
     * @param result result
     * @return レスポンス
     */
    public static CreatedResponse toCreatedResponse(CreateUserResult result) {
        return new CreatedResponse()
                .code(ResponseCode.SUCCESS.name())
                .message("ユーザーを作成しました。（id＝" + result.getId() + "）");
    }
}
