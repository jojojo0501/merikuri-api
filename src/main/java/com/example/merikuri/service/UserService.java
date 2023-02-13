package com.example.merikuri.service;

import com.example.merikuri.model.User;
import com.example.merikuri.model.UserForm;
import com.example.merikuri.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(UserForm form){
        userRepository.insert(User.fromForm(form));
    }
}
