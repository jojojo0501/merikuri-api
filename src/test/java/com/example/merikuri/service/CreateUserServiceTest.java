package com.example.merikuri.service;

import com.example.merikuri.UnitTestWithMock;
import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.param.UserFormParam;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.exception.CheckedException;
import com.example.merikuri.generated.model.CreateUserRequest;
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
class CreateUserServiceTest {

    @InjectMocks
    CreateUserService createUserService;

    @Mock
    UserRepository userRepository;

    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(createUserService);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("createUser_正常系")
    void createUser1() throws CheckedException {

        // データ準備
        UserFormParam param = new UserFormParam(
                new CreateUserRequest()
                        .firstName("山田")
                        .lastName("太郎")
                        .age(30)
                        .tel("000-1234-5678")
                        .address("カスピ海")
                        .email("test@gmail.com")
                        .password("tarodayo")
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
        Mockito.when(userRepository.findByEmail(any())).thenReturn(new ArrayList<>());
        Mockito.when(userRepository.register(any())).thenReturn(repositoryResult);

        //　テスト実行
        CreateUserResult actual = createUserService.createUser(param);

        // 結果検証
        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(any());
        Mockito.verify(userRepository, Mockito.times(1)).register(any());

        assertNotNull(actual);
        assertEquals(1L, actual.getId());

    }

    @Test
    @DisplayName("createUser_異常系_既に登録されているメールアドレス")
    void createUser2() {
        // データ準備
        UserFormParam param = new UserFormParam(
                new CreateUserRequest()
                        .firstName("山田")
                        .lastName("太郎")
                        .age(30)
                        .tel("000-1234-5678")
                        .address("カスピ海")
                        .email("test@gmail.com")
                        .password("tarodayo")
        );
        UserBase userBase = new UserBase();
        userBase.setId(2L);
        userBase.setFirstName("山田");
        userBase.setLastName("花子");
        userBase.setAge(15);
        userBase.setTel("000-1234-9876");
        userBase.setAddress("富士山");
        userBase.setEmail("hanako@gmail.com");
        userBase.setPassword("hanakodayo");
        User repositoryResult = User.fromBase(userBase);

        // モックの動作を指定
        Mockito.when(userRepository.findByEmail(any())).thenReturn(List.of(repositoryResult));

        //　テスト実行
        CheckedException e = assertThrows(CheckedException.class, () ->
                createUserService.createUser(param));

        // 結果検証
        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(any());
        Mockito.verify(userRepository, Mockito.never()).register(any());

        assertEquals(ResponseCode.BAD_REQUEST, e.getCode());
        assertEquals("既に登録されているメールアドレスです。", e.getMessage());

    }

}