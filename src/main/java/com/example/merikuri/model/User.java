package com.example.merikuri.model;

import com.example.merikuri.common.constant.DeleteFlg;
import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.mapper.domain.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class User {

    public User(String firstName, String lastName, Integer age,
                String tel, String address, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String tel;

    private String address;

    private String email;

    private String password;


    public static User fromParam(UserFormParam param) {
        return new User(
                param.getRequest().getFirstName(),
                param.getRequest().getLastName(),
                param.getRequest().getAge(),
                param.getRequest().getTel(),
                param.getRequest().getAddress(),
                param.getRequest().getEmail(),
                param.getRequest().getPassword()
        );
    }

    public static UserBase fromModel(User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return new UserBase(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getTel(),
                user.getAddress(),
                user.getEmail(),
                user.getPassword(),
                localDateTime,
                localDateTime,
                DeleteFlg.FLG_OFF.getValue()
        );
    }

    public static User fromBase(UserBase base) {
        return new User(base.getId(),
                base.getFirstName(),
                base.getLastName(),
                base.getAge(),
                base.getTel(),
                base.getAddress(),
                base.getEmail(),
                base.getPassword()
        );
    }

}
