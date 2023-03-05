package com.example.merikuri.service;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.param.LoginParam;
import com.example.merikuri.controller.result.LoginResult;
import com.example.merikuri.exception.CheckedException;
import com.example.merikuri.model.User;
import com.example.merikuri.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ログインのService.
 */
@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    /**
     * ログインする.
     *
     * @return ユーザー情報
     */
    public LoginResult login(LoginParam param) throws CheckedException {

        List<User> userList = userRepository
                .findByEmailAndPassword(param.getEmail(), param.getPassword());

        if (userList.size() > 1) {
            throw new CheckedException(ResponseCode.SERVER_ERROR, "予期せぬエラーが発生しました。");
        }

        User user = userList.stream().findFirst()
                .orElseThrow(() -> new CheckedException(
                        ResponseCode.BAD_REQUEST,
                        "メールアドレスまたはパスワードが違います。")
                );

        return new LoginResult(user);
    }
}
