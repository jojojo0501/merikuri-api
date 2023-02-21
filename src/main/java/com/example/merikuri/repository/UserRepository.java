package com.example.merikuri.repository;

import com.example.merikuri.mapper.UserBaseMapper;
import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * ユーザー情報を扱うリポジトリ.
 */
@Repository
@AllArgsConstructor
public class UserRepository {

    private final UserBaseMapper userBaseMapper;

    /**
     * 登録する.
     *
     * @param user 登録するユーザー
     * @return 登録したユーザー
     */
    public User register(User user) {
        UserBase base = User.fromModel(user);
        userBaseMapper.insert(base);
        return User.fromBase(base);
    }

}
