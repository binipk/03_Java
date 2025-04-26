package com.ohgiraffers.token;

import java.util.Arrays;

public class TokenTest {

    public static void main(String[] args) {
        String text = "J a v a P r o g r a m ";
        String[] result = text.split(" ");
        char[] chars = new char[result.length];

        for (int i = 0; i < result.length; i++) {
            chars[i] = result[i].charAt(0);
        }
        System.out.println(Arrays.toString(chars));
        String text2 = new String(chars);
        System.out.println(text2);
        // new String을 쓰면 문자열로 변환 가능
        System.out.println(text2.toUpperCase()); // 완료

    }
}
