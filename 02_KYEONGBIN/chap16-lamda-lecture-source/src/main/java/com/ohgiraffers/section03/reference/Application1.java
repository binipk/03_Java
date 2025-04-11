package com.ohgiraffers.section03.reference;

import java.util.function.BiFunction;

public class Application1 {
    public static void main(String[] args) {

        // 메소드 참조 표현식
        // 클래스 이름 : 메소드 이름
        // 참조변수 이름 : 메소드 이름

        BiFunction<String, String, Boolean> bf = (str1, str2) -> str1.equals(str2);
        System.out.println(bf.apply("Hello", "Hello"));

        BiFunction<String, String, Boolean> biFunction = String::equals;
        System.out.println(biFunction.apply("Hello", "Hello"));
    }
}
