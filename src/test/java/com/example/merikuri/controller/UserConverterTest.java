package com.example.merikuri.controller;

import com.example.merikuri.UnitTestWithoutMock;
import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.controller.result.LoginResult;
import com.example.merikuri.generated.model.CreatedResponse;
import com.example.merikuri.generated.model.LoginResponse;
import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@UnitTestWithoutMock
class UserConverterTest {

    UserConverter userConverter = new UserConverter();

    @Test
    @DisplayName("toCreatedResponse_正常系")
    void toCreatedResponse1() {

        //　データ準備＆テスト実行
        CreatedResponse actual = userConverter.toCreatedResponse(new CreateUserResult(1l));

        // 結果検証
        assertNotNull(actual);
        assertEquals(ResponseCode.SUCCESS.name(), actual.getCode());
        assertEquals("ユーザーを作成しました。（id＝1）", actual.getMessage());

    }

    @Test
    @DisplayName("toLoginResponse_正常系")
    void toLoginResponse1() {

        //　データ準備
        UserBase userBase = new UserBase();
        userBase.setId(1L);
        userBase.setFirstName("山田");
        userBase.setLastName("太郎");
        userBase.setAge(30);
        userBase.setTel("000-1234-5678");
        userBase.setAddress("カスピ海");
        userBase.setEmail("test@gmail.com");
        userBase.setPassword("tarodayo");
        LoginResult seviceResult = new LoginResult(User.fromBase(userBase));
        // テスト実行
        LoginResponse actual = userConverter.toLoginResponse(seviceResult);

        // 結果検証
        assertNotNull(actual);
        assertEquals(ResponseCode.SUCCESS.name(), actual.getCode());
        assertEquals("ログインに成功しました。", actual.getMessage());
        assertEquals(1L, actual.getInfo().getUserId());
        assertEquals("山田", actual.getInfo().getFirstName());
        assertEquals("太郎", actual.getInfo().getLastName());
        assertEquals(30, actual.getInfo().getAge());
        assertEquals("000-1234-5678", actual.getInfo().getTel());
        assertEquals("カスピ海", actual.getInfo().getAddress());
        assertEquals("test@gmail.com", actual.getInfo().getEmail());

    }

}