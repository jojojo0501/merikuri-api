package com.example.merikuri.controller;

import com.example.merikuri.model.UserDTO;
import com.example.merikuri.model.UserForm;
import com.example.merikuri.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController  implements UsersApi{

    private final UserService userService;

    @Override
    public ResponseEntity<UserDTO> createUser(UserForm form){
        userService.createUser(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
