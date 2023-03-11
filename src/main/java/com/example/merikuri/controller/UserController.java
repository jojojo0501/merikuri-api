package com.example.merikuri.controller;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.param.LoginParam;
import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.exception.BadRequestException;
import com.example.merikuri.exception.CheckedException;
import com.example.merikuri.exception.ServerErrorException;
import com.example.merikuri.generated.controller.UsersApi;
import com.example.merikuri.generated.model.CreateUserRequest;
import com.example.merikuri.generated.model.CreatedResponse;
import com.example.merikuri.generated.model.LoginResponse;
import com.example.merikuri.service.CreateUserService;
import com.example.merikuri.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * ユーザー情報を扱うController.
 */
@RestController
@AllArgsConstructor
public class UserController implements UsersApi {

    private final CreateUserService createUserService;
    private final LoginService loginService;
    private final UserConverter userConverter;

    /**
     * 新規ユーザーを作成する.
     *
     * @param request リクエストボディ
     * @return レスポンス
     */
    @Override
    public ResponseEntity<CreatedResponse> createUser(CreateUserRequest request) {
        CreatedResponse response = null;
        try {
            response = userConverter.toCreatedResponse(
                    createUserService.createUser(new UserFormParam(request))
            );
        } catch (CheckedException e) {
            if (ResponseCode.BAD_REQUEST == e.getCode()) {
                throw new BadRequestException(e.getMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * ログインする.
     *
     * @param email    メールアドレス
     * @param password パスワード
     * @return レスポンス
     */
    @Override
    public ResponseEntity<LoginResponse> login(String email, String password) {

        LoginResponse response = null;
        try {
            response = userConverter.toLoginResponse(
                    loginService.login(new LoginParam(email, password))
            );
        } catch (CheckedException e) {
            if (ResponseCode.BAD_REQUEST == e.getCode()) {
                throw new BadRequestException(e.getMessage());
            }
            if (ResponseCode.SERVER_ERROR == e.getCode()) {
                throw new ServerErrorException(e.getMessage());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
