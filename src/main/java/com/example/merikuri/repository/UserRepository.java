package com.example.merikuri.repository;

import com.example.merikuri.mapper.UserBaseMapper;
import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final UserBaseMapper userBaseMapper;

    public User register(User user){
        UserBase base = User.fromModel(user);
        userBaseMapper.insert(base);
        return User.fromBase(base);
    }

}
