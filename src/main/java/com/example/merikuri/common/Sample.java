package com.example.merikuri.common;

import org.springframework.stereotype.Component;

@Component
public class Sample {

    /**
     * 引数の和を返す.
     * 0未満が入力された場合Runtimeを返す.
     *
     * @param x x
     * @param y y
     * @return 和
     */
    public int add(int x, int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("だめだよ");
        }
        return x + y;
    }
}
