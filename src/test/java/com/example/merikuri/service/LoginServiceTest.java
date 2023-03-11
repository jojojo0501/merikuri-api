package com.example.merikuri.service;

import com.example.merikuri.UnitTestWithMock;
import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.param.LoginParam;
import com.example.merikuri.controller.result.LoginResult;
import com.example.merikuri.exception.CheckedException;
import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.model.User;
import com.example.merikuri.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@UnitTestWithMock
class LoginServiceTest {

    @InjectMocks
    LoginService loginService;

    @Mock
    UserRepository userRepository;

    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(loginService);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("login_正常系")
    void login1() throws CheckedException {
        // データ準備
        LoginParam loginParam = new LoginParam(
                "test@gmail.com",
                "tarodayo"
        );
        UserBase userBase = new UserBase();
        userBase.setId(1L);
        userBase.setFirstName("山田");
        userBase.setLastName("太郎");
        userBase.setAge(30);
        userBase.setTel("000-1234-5678");
        userBase.setAddress("カスピ海");
        userBase.setEmail("test@gmail.com");
        userBase.setPassword("tarodayo");
        User repositoryResult = User.fromBase(userBase);

        // モックの動作を指定
        Mockito.when(userRepository.findByEmailAndPassword(any(), any()))
                .thenReturn(List.of(repositoryResult));

        //　テスト実行
        LoginResult actual = loginService.login(loginParam);

        // 結果検証
        Mockito.verify(userRepository, Mockito.times(1))
                .findByEmailAndPassword(any(), any());

        assertNotNull(actual);
        assertEquals(1L, actual.getUser().getId());
        assertEquals("山田", actual.getUser().getFirstName());
        assertEquals("太郎", actual.getUser().getLastName());
        assertEquals(30, actual.getUser().getAge());
        assertEquals("000-1234-5678", actual.getUser().getTel());
        assertEquals("カスピ海", actual.getUser().getAddress());
        assertEquals("test@gmail.com", actual.getUser().getEmail());
        assertEquals("tarodayo", actual.getUser().getPassword());
    }

    @Test
    @DisplayName("login_異常系_メールアドレス又はパスワードが不正")
    void login2() {
        // データ準備
        LoginParam loginParam = new LoginParam(
                "test@gmail.com",
                "tarodayo"
        );

        // モックの動作を指定
        Mockito.when(userRepository.findByEmailAndPassword(any(), any()))
                .thenReturn(new ArrayList<>());

        //　テスト実行
        CheckedException ex = assertThrows(CheckedException.class, () ->
                loginService.login(loginParam));

        // 結果検証
        Mockito.verify(userRepository, Mockito.times(1))
                .findByEmailAndPassword(any(), any());

        assertEquals(ResponseCode.BAD_REQUEST, ex.getCode());
        assertEquals("メールアドレスまたはパスワードが違います。", ex.getMessage());
    }

    @Test
    @DisplayName("login_異常系_予期せぬエラー")
    void login3() {
        // データ準備
        LoginParam loginParam = new LoginParam(
                "test@gmail.com",
                "tarodayo"
        );
        UserBase userBase = new UserBase();
        userBase.setId(1L);
        userBase.setFirstName("山田");
        userBase.setLastName("太郎");
        userBase.setAge(30);
        userBase.setTel("000-1234-5678");
        userBase.setAddress("カスピ海");
        userBase.setEmail("test@gmail.com");
        userBase.setPassword("tarodayo");
        User repositoryResult = User.fromBase(userBase);

        // モックの動作を指定
        Mockito.when(userRepository.findByEmailAndPassword(any(), any()))
                .thenReturn(List.of(repositoryResult, repositoryResult));

        //　テスト実行
        CheckedException ex = assertThrows(CheckedException.class, () ->
                loginService.login(loginParam));

        // 結果検証
        Mockito.verify(userRepository, Mockito.times(1))
                .findByEmailAndPassword(any(), any());

        assertEquals(ResponseCode.SERVER_ERROR, ex.getCode());
        assertEquals("予期せぬエラーが発生しました。", ex.getMessage());
    }

}