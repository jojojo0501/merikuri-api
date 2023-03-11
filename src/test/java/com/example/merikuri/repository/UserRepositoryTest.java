package com.example.merikuri.repository;

import com.example.merikuri.UnitTestForRepositoryAndMapper;
import com.example.merikuri.common.constant.DeleteFlg;
import com.example.merikuri.mapper.UserBaseMapper;
import com.example.merikuri.mapper.domain.UserBase;
import com.example.merikuri.mapper.domain.UserBaseExample;
import com.example.merikuri.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnitTestForRepositoryAndMapper
@Sql("classpath:sql/user-repository.sql")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBaseMapper userBaseMapper;

    @Test
    @DisplayName("register_正常系")
    void register1() {

        // データの準備
        UserBase userBase = new UserBase();
        userBase.setId(1L);
        userBase.setFirstName("register");
        userBase.setLastName("次郎");
        userBase.setAge(45);
        userBase.setTel("000-1234-5679");
        userBase.setAddress("次郎のお家");
        userBase.setEmail("jiro@gmail.com");
        userBase.setPassword("jirodayo");
        User user = User.fromBase(userBase);

        // テストの実行
        User actual = userRepository.register(user);

        // 結果の検証
        UserBaseExample criteria = new UserBaseExample();
        criteria.createCriteria()
                .andFirstNameEqualTo("register")
                .andLastNameEqualTo("次郎")
                .andEmailEqualTo("jiro@gmail.com")
                .andDeleteFlgEqualTo(DeleteFlg.FLG_OFF.getValue());
        assertEquals(1, userBaseMapper.selectByExample(criteria).size());

        // user_idはPRIMARY KEYとAUTOINCREMENTを指定しているため、テスト毎に結果が異なるため省略
        assertEquals("register", actual.getFirstName());
        assertEquals("次郎", actual.getLastName());
        assertEquals(45, actual.getAge());
        assertEquals("000-1234-5679", actual.getTel());
        assertEquals("次郎のお家", actual.getAddress());
        assertEquals("jiro@gmail.com", actual.getEmail());
        assertEquals("jirodayo", actual.getPassword());
    }

    @Test
    @DisplayName("findByEmail_正常系")
    void findByEmail1() {

        // テストの実行
        List<User> actual = userRepository.findByEmail("test1@gmail.com");

        // 結果の検証
        assertEquals(1, actual.size());
        assertEquals(100L, actual.get(0).getId());
        assertEquals("FIRST_NAME", actual.get(0).getFirstName());
        assertEquals("LAST_NAME", actual.get(0).getLastName());
        assertEquals(10, actual.get(0).getAge());
        assertEquals("090-1234-5678", actual.get(0).getTel());
        assertEquals("ADDRESS", actual.get(0).getAddress());
        assertEquals("test1@gmail.com", actual.get(0).getEmail());
        assertEquals("PASSWORD1", actual.get(0).getPassword());
    }

    @Test
    @DisplayName("findByEmailAndPassword_正常系")
    void findByEmailAndPassword1() {

        // テストの実行
        List<User> actual = userRepository
                .findByEmailAndPassword("test2@gmail.com", "PASSWORD2");

        // 結果の検証
        assertEquals(1, actual.size());
        assertEquals(102L, actual.get(0).getId());
        assertEquals("FIRST_NAME", actual.get(0).getFirstName());
        assertEquals("LAST_NAME", actual.get(0).getLastName());
        assertEquals(10, actual.get(0).getAge());
        assertEquals("090-1234-5678", actual.get(0).getTel());
        assertEquals("ADDRESS", actual.get(0).getAddress());
        assertEquals("test2@gmail.com", actual.get(0).getEmail());
        assertEquals("PASSWORD2", actual.get(0).getPassword());
    }
}