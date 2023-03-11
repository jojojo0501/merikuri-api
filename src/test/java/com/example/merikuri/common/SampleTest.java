package com.example.merikuri.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SampleTest {

    Sample sample = new Sample();

    @Test
    @DisplayName("add_正常系")
    void add1() {// テストデータ準備
        int x = 2;
        int y = 3;
        // テストの実行
        int actual = sample.add(x, y);
        // テスト結果の検証
        assertEquals(5, actual); //第一引数に期待値、第二引数に実行結果
    }

   @ParameterizedTest
   @CsvSource({
           "-1,0", // xが-1
           "0,-1", // yが-1
           "-1,-1" //x,yともに-1
   })
    void add2(int x, int y) {
        // テストデータ準備（メソッドのパラメータで渡している。）
        // テストの実行＆テスト結果の検証
        RuntimeException e = assertThrows(RuntimeException.class, () -> sample.add(x, y));
        assertEquals("だめだよ", e.getMessage());

    }

}