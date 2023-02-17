package com.example.merikuri.service;

import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.model.User;
import com.example.merikuri.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public CreateUserResult createUser(UserFormParam param) {
        User user = userRepository.register(User.fromParam(param));
        return CreateUserResult.fromModel(user);
    }
}
