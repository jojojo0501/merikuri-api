package com.example.merikuri.model;

import com.example.merikuri.common.constant.DeleteFlg;
import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.mapper.domain.UserBase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ユーザーモデル.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
     * @param param param
     */
    public User(UserFormParam param) {
        this.firstName = param.getRequest().getFirstName();
        this.lastName = param.getRequest().getLastName();
        this.age = param.getRequest().getAge();
        this.tel = param.getRequest().getTel();
        this.address = param.getRequest().getAddress();
        this.email = param.getRequest().getEmail();
        this.password = param.getRequest().getPassword();
    }

    public User(UserBase base) {
        this.id = base.getId();
        this.firstName = base.getFirstName();
        this.lastName = base.getLastName();
        this.age = base.getAge();
        this.tel = base.getTel();
        this.address = base.getAddress();
        this.email = base.getEmail();
        this.password = base.getPassword();
    }

    /**
     * paramをmodelに変換する.
     *
     * @param param param
     * @return モデル
     */
    public static User fromParam(UserFormParam param) {
        return new User(param);
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
        return new User(base);
    }

    /**
     * baseリストをmodelリストに変換する.
     *
     * @param baselist データリスト
     * @return modelList
     */
    public static List<User> fromBaseList(List<UserBase> baselist) {
        return baselist.stream().map(User::fromBase).collect(Collectors.toList());
    }
}
