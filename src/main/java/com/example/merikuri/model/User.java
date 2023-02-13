package com.example.merikuri.model;

import com.example.merikuri.mapper.domain.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class User {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String tel;

    private String address;

    private String email;

    private String password;

    public static User fromForm(UserForm form){
        return new User(
                Long.valueOf(3),
                form.getFirstName(),
                form.getLastName(),
                form.getAge(),
                form.getTel(),
                form.getAddress(),
                form.getEmail(),
                "password"
        );
    }

    public static UserBase fromModel(User user) {
        return new UserBase(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getTel(),
                user.getAddress(),
                user.getEmail(),
                user.getPassword(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                false
        );
    }

}
