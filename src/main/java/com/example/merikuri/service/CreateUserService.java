package com.example.merikuri.service;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.exception.CheckedException;
import com.example.merikuri.model.User;
import com.example.merikuri.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ユーザー登録のService.
 */
@Service
@AllArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;

    /**
     * /**
     * ユーザーを登録する.
     *
     * @param param リクエスト情報
     * @return 作成結果
     * @throws CheckedException checkedException
     */
    @Transactional
    public CreateUserResult createUser(UserFormParam param)
            throws CheckedException {

        List<User> existUser = userRepository
                .findByEmail(param.getRequest().getEmail());

        if (!existUser.isEmpty()) {
            throw new CheckedException(ResponseCode.BAD_REQUEST, "既に登録されているメールアドレスです。");
        }

        User user = userRepository.register(User.fromParam(param));
        return new CreateUserResult(user.getId());
    }
}
