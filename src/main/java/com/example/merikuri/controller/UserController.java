package com.example.merikuri.controller;

import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.model.CreateUserRequest;
import com.example.merikuri.model.CreatedResponse;
import com.example.merikuri.service.UserService;
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

    private final UserService userService;

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
            response = UserConverter.toCreatedResponse(
                    userService.createUser(new UserFormParam(request))
            );
        } catch (Exception e) {
            //TODO 例外処理（Handler実装）
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
