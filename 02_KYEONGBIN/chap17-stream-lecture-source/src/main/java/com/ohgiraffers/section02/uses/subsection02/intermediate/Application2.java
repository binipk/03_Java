package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application2 {
    public static void main(String[] args) {

        /*
         * ✅ map은 스트림 안의 데이터를 "변형"시키는 메서드예요.
         *
         * 예를 들어:
         * - 숫자에 10을 더하기
         * - 문자열을 대문자로 바꾸기
         * - 객체에서 특정 필드만 뽑기 등등...
         *
         * 원래 데이터를 수정하지 않고, 가공한 새 데이터를 새로운 스트림으로 만들어줘요.
         *
         * 💡 map 내부에는 Function이라는 인터페이스가 들어가요.
         * Function은 어떤 값을 받아서 → 다른 값으로 바꿔주는 역할이에요.
         *
         * 예시:
         * list.stream().map(n -> n + 10);
         * → 리스트에 있는 숫자에 10을 더해서 새로운 스트림을 만든다는 의미예요.
         */

        // IntStream.range(1, 10) → 1부터 9까지 숫자 생성
        IntStream iS = IntStream.range(1, 10);

        // 1) 짝수만 필터링
        // 2) 짝수에 5를 곱함
        // 3) 결과 출력
        iS.filter(i -> i % 2 == 0)      // 짝수만 남김 (2, 4, 6, 8)
                .map(i -> i * 5)              // 각 숫자에 5를 곱함 (10, 20, 30, 40)
                .forEach(i -> System.out.print(i + " ")); // 출력

        // 출력 결과: 10 20 30 40
    }
}
