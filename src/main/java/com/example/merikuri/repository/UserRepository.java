package com.example.merikuri.repository;

import com.example.merikuri.common.constant.DeleteFlg;
import com.example.merikuri.mapper.UserBaseMapper;
import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.mapper.domain.UserBaseExample;
import com.example.merikuri.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 検索する（メールアドレス）.
     * @param email メールアドレス
     * @return 検索結果
     */
    public List<User> findByEmail(String email) {
        UserBaseExample criteria = new UserBaseExample();
        criteria.createCriteria()
                .andEmailEqualTo(email)
                .andDeleteFlgEqualTo(DeleteFlg.FLG_OFF.getValue());

        return User.fromBaseList(userBaseMapper.selectByExample(criteria));
    }


    /**
     * 検索する（メールアドレス＆パスワード）.
     * @param email メールアドレス
     * @param password パスワード
     * @return 検索結果
     */
    public List<User> findByEmailAndPassword(String email,String password) {
        UserBaseExample criteria = new UserBaseExample();
        criteria.createCriteria()
                .andEmailEqualTo(email)
                .andPasswordEqualTo(password)
                .andDeleteFlgEqualTo(DeleteFlg.FLG_OFF.getValue());

        return User.fromBaseList(userBaseMapper.selectByExample(criteria));
    }

}
