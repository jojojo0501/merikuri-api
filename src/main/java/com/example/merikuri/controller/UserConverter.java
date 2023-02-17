package com.example.merikuri.controller;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.model.CreatedResponse;

public class UserConverter {

    public static CreatedResponse toCreatedResponse(CreateUserResult result) {
        return new CreatedResponse()
                .code(ResponseCode.SUCCESS.name())
                .message("ユーザーを作成しました。（id＝" + result.getId() + "）");
    }
}
