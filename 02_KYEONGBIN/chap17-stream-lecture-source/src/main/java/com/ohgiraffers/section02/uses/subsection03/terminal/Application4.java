package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {

    public static void main(String[] args) {

        // match 계열 메서드: 스트림 내 값들이 조건을 만족하는지 검사
        // 결과는 모두 boolean (true / false)

        List<String> stringList = Arrays.asList("java", "Spring", "SpringBoot");

        // --------------------------------------
        // anyMatch(): 하나라도 조건을 만족하면 true
        // → "p"가 포함된 문자열이 하나라도 있는가?
        boolean anyMatch = stringList.stream()
                .anyMatch(str -> str.contains("p")); // true

        // --------------------------------------
        // allMatch(): 모두 조건을 만족해야 true
        // → 모든 문자열 길이가 4 이상인가?
        boolean allMatch = stringList.stream()
                .allMatch(str -> str.length() >= 4); // true

        // --------------------------------------
        // noneMatch(): 전부 조건을 만족하지 않아야 true
        // → "o"를 포함한 문자열이 하나도 없는가?
        boolean noneMatch = stringList.stream()
                .noneMatch(str -> str.contains("o")); // false ("SpringBoot" 포함)

        // 결과 출력
        System.out.println("anyMatch: " + anyMatch);     // true
        System.out.println("allMatch: " + allMatch);     // true
        System.out.println("noneMatch: " + noneMatch);   // false
    }
}
