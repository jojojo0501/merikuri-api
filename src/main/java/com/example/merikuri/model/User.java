package com.example.merikuri.model;

import com.example.merikuri.common.constant.DeleteFlg;
import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.mapper.domain.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ユーザーモデル.
 */
@AllArgsConstructor
@Data
public class User {

    /**
     * id
     */
    private Long id;

    /**
     * 名前
     */
    private String firstName;

    /**
     * 苗字
     */
    private String lastName;

    /**
     * 年齢
     */
    private Integer age;

    /**
     * 電話番号
     */
    private String tel;

    /**
     * 住所
     */
    private String address;

    /**
     * メール
     */
    private String email;

    /**
     * パスワード
     */
    private String password;

    /**
     * コンストラクタ.
     *
     * @param firstName firstName
     * @param lastName  lastName
     * @param age       age
     * @param tel       tel
     * @param address   address
     * @param email     email
     * @param password  password
     */
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

    /**
     * paramをmodelに変換する.
     *
     * @param param param
     * @return モデル
     */
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

    /**
     * modelをbaseに変換する.
     *
     * @param user モデル
     * @return base
     */
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

    /**
     * baseをmodelに変換する.
     *
     * @param base base
     * @return model
     */
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
