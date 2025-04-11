package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application1 {

    public static void main(String[] args) {

        /*
         * ✅ filter는 스트림에서 '원하는 조건에 맞는 데이터만 골라내는' 메서드예요.
         *
         * 예를 들어:
         * - 숫자 중에서 짝수만 고르기
         * - 문자열 중에서 길이가 3 이상인 것만 고르기
         *
         * filter 안에는 true 또는 false를 리턴하는 조건을 넣어야 해요.
         * 이 조건은 Predicate라는 함수형 인터페이스를 사용해 표현돼요.
         *
         * 💡 예시:
         * list.stream().filter(n -> n % 2 == 0);
         * → 리스트에서 짝수만 남긴다는 의미예요.
         */

        // 0부터 8까지(IntStream.range(0, 9)) 생성
        IntStream iS = IntStream.range(0, 9);

        // filter를 사용해 짝수만 걸러내고 출력
        iS.filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(i + " "));

        // 출력 결과: 0 2 4 6 8
    }
}
