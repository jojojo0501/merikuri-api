package com.example.merikuri;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * UTアノテーション.
 * モックを使用しないテストに付与してください。
 * (主にmodel、converter、validator)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public @interface UnitTestWithoutMock {
}
