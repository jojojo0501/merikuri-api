package com.example.merikuri.controller.result;

import com.example.merikuri.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserResult {

    private long id;

    public static CreateUserResult fromModel(User user){
        return new CreateUserResult(user.getId());
    }
}
