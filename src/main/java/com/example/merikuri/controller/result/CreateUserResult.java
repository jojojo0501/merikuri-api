package com.example.merikuri.controller.result;

import com.example.merikuri.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー作成のResult.
 */
@AllArgsConstructor
@Getter
public class CreateUserResult {

    /**
     * ユーザーID
     */
    private long id;

    /**
     * モデルからresultを生成する.
     *
     * @param user モデル
     * @return result
     */
    public static CreateUserResult fromModel(User user) {
        return new CreateUserResult(user.getId());
    }
}
