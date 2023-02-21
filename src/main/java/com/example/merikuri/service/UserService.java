package com.example.merikuri.service;

import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.model.User;
import com.example.merikuri.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ユーザー情報を扱うService.
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * ユーザーを作成する.
     *
     * @param param リクエスト情報
     * @return 作成結果
     */
    @Transactional
    public CreateUserResult createUser(UserFormParam param) {
        User user = userRepository.register(User.fromParam(param));
        return CreateUserResult.fromModel(user);
    }
}
