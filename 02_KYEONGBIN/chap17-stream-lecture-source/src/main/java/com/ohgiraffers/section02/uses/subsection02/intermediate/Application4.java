package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application4 {
    public static void main(String[] args) {

        /*
         * ✅ sorted()는 스트림의 데이터를 정렬해주는 메서드예요.
         *
         * - sorted()만 쓰면 기본 오름차순 정렬이 돼요.
         *   예: 숫자는 1 → 10, 문자는 A → Z 순서로
         *
         * - 내가 원하는 정렬 방식(내림차순, 길이순 등)을 쓰고 싶으면
         *   sorted(Comparator)를 사용해서 기준을 설정해주면 돼요.
         */

        // IntStream.of(...)는 주어진 숫자들로 스트림을 만듭니다.
        // boxed()로 기본형 int → Integer 객체로 바꿔줘야 List로 수집할 수 있어요.
        // sorted()는 오름차순 정렬.
        // collect(Collectors.toList())로 최종적으로 리스트로 바꿔요.

        List<Integer> iL = IntStream.of(5, 10, 99, 2, 1, 36)
                .boxed()                // int → Integer (Wrapper 클래스로 포장)
                .sorted()              // 오름차순 정렬
                .collect(Collectors.toList()); // List로 수집

        System.out.println("Sorted: " + iL);
        // 출력: Sorted: [1, 2, 5, 10, 36, 99]
    }
}
