package com.example.merikuri.controller;

import com.example.merikuri.UnitTestWithSpringBoot;
import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.controller.result.CreateUserResult;
import com.example.merikuri.controller.result.LoginResult;
import com.example.merikuri.exception.CheckedException;
import com.example.merikuri.exception.CommonExceptionHandler;
import com.example.merikuri.generated.model.CreatedResponse;
import com.example.merikuri.generated.model.LoginResponse;
import com.example.merikuri.generated.model.LoginResponseInfo;
import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.model.User;
import com.example.merikuri.service.CreateUserService;
import com.example.merikuri.service.LoginService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@UnitTestWithSpringBoot
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private CreateUserService createUserService;

    @Mock
    private LoginService loginService;

    @Mock
    private UserConverter userConverter;

    @Autowired
    CommonExceptionHandler commonExceptionHandler;

    private MockMvc mockMvc;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(userController);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(commonExceptionHandler)
                .build();
    }

    @AfterEach
    void closeMocks() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("createUser_正常系")
    void createUser1() throws Exception {

        // データ準備
        // モックの動作を指定
        Mockito.when(createUserService.createUser(any())).thenReturn(new CreateUserResult(1L));
        Mockito.when(userConverter.toCreatedResponse(any()))
                .thenReturn(new CreatedResponse()
                        .code(ResponseCode.SUCCESS.name())
                        .message("ユーザーを作成しました。（id＝1）"));

        String requestBody = "{\n" +
                "  \"firstName\": \"田中\",\n" +
                "  \"lastName\": \"太郎\",\n" +
                "  \"age\": \"12\",\n" +
                "  \"tel\": \"080-8726-2211\",\n" +
                "  \"address\": \"じゅうしょ\",\n" +
                "  \"email\": \"test@gmail.com\",\n" +
                "  \"password\": \"password\"\n" +
                "}";
        String expected = "{\"code\":\"SUCCESS\",\"message\":\"ユーザーを作成しました。（id＝1）\"}";

        //　実行
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post("/users")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
        String actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        // 結果検証
        Mockito.verify(createUserService, Mockito.times(1)).createUser(any());
        Mockito.verify(userConverter, Mockito.times(1)).toCreatedResponse(any());

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("createUser_異常系_400")
    void createUser2() throws Exception {

        // データ準備
        // モックの動作を指定
        Mockito.when(createUserService.createUser(any()))
                .thenThrow(new CheckedException(ResponseCode.BAD_REQUEST, "既に登録されているメールアドレスです。"));

        String requestBody = "{\n" +
                "  \"firstName\": \"田中\",\n" +
                "  \"lastName\": \"太郎\",\n" +
                "  \"age\": \"12\",\n" +
                "  \"tel\": \"080-8726-2211\",\n" +
                "  \"address\": \"じゅうしょ\",\n" +
                "  \"email\": \"test@gmail.com\",\n" +
                "  \"password\": \"password\"\n" +
                "}";
        String expected = "{\"code\":\"BAD_REQUEST\"," +
                "\"message\":\"既に登録されているメールアドレスです。\",\"invalid-params\":null}";

        //　実行
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post("/users")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
        String actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        // 結果検証
        Mockito.verify(createUserService, Mockito.times(1)).createUser(any());
        Mockito.verify(userConverter, Mockito.never()).toCreatedResponse(any());

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("login_正常系")
    void login1() throws Exception {
        // データ準備
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
        LoginResponse converterResult = new LoginResponse()
                .code(ResponseCode.SUCCESS.name())
                .message("ログインに成功しました。")
                .info(new LoginResponseInfo()
                        .userId(1L)
                        .firstName("山田")
                        .lastName("太郎")
                        .age(30)
                        .tel("000-1234-5678")
                        .address("カスピ海")
                        .email("test@gmail.com")
                );
        // モックの動作を指定
        Mockito.when(loginService.login(any())).thenReturn(seviceResult);
        Mockito.when(userConverter.toLoginResponse(any())).thenReturn(converterResult);

        String expected = "{\"code\":\"SUCCESS\"," +
                "\"message\":\"ログインに成功しました。\"" +
                ",\"info\":{\"userId\":1," +
                "\"firstName\":\"山田\"," +
                "\"lastName\":\"太郎\"," +
                "\"age\":30," +
                "\"tel\":\"000-1234-5678\"," +
                "\"address\":\"カスピ海\"," +
                "\"email\":\"test@gmail.com\"}}";

        //　実行
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get("/login?email=test@gmail.com&password=password")
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
        String actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        // 結果検証
        Mockito.verify(loginService, Mockito.times(1)).login(any());
        Mockito.verify(userConverter, Mockito.times(1)).toLoginResponse(any());

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("login_異常系_400")
    void login2() throws Exception {

        // モックの動作を指定
        Mockito.when(loginService.login(any()))
                .thenThrow(new CheckedException(ResponseCode.BAD_REQUEST, "メールアドレスまたはパスワードが違います。"));

        String expected = "{\"code\":\"BAD_REQUEST\"," +
                "\"message\":\"メールアドレスまたはパスワードが違います。\",\"invalid-params\":null}";

        //　実行
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get("/login?email=test@gmail.com&password=password")
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
        String actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        // 結果検証
        Mockito.verify(loginService, Mockito.times(1)).login(any());
        Mockito.verify(userConverter, Mockito.never()).toLoginResponse(any());

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("login_異常系_500")
    void login3() throws Exception {

        // モックの動作を指定
        Mockito.when(loginService.login(any()))
                .thenThrow(new CheckedException(ResponseCode.SERVER_ERROR, "予期せぬエラーが発生しました。"));

        String expected = "{\"code\":\"SERVER_ERROR\"," +
                "\"message\":\"予期せぬエラーが発生しました。\"}";

        //　実行
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get("/login?email=test@gmail.com&password=password")
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
        String actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        // 結果検証
        Mockito.verify(loginService, Mockito.times(1)).login(any());
        Mockito.verify(userConverter, Mockito.never()).toLoginResponse(any());

        assertEquals(expected, actual);
    }
}