package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {

        /*
         * ✅ reduce()란?
         * 스트림 안의 데이터를 "하나로 합치는" 메서드예요.
         *
         * 예를 들어 숫자들의 총합을 구하거나, 문자열들을 이어 붙이는 데 자주 써요.
         * [1, 2, 3] → reduce로 더하면 → 6
         *
         * 세 가지 형태가 있어요:
         *
         * 1️⃣ Optional<T> reduce(BinaryOperator<T> accumulator)
         *     → 처음 값부터 끝까지 누적해서 하나의 값으로!
         *
         * 2️⃣ T reduce(T identity, BinaryOperator<T> accumulator)
         *     → 누적 시작값(identity)을 지정해서 계산!
         *
         * 3️⃣ U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
         *     → 병렬 처리용 (조금 고급 개념!)
         */

        // 🎯 1. 인자 1개: Optional로 결과가 나와요
        OptionalInt rO = IntStream.range(1, 4)  // 1, 2, 3
                .reduce((a, b) -> Integer.sum(a, b));  // 1+2+3
        System.out.println("rO: " + rO.getAsInt());  // 출력: 6

        // 🎯 2. 인자 2개: 시작값(identity)을 주고 누적
        int rT = IntStream.range(1, 4)  // 1, 2, 3
                .reduce(100, Integer::sum);  // 100 + 1 + 2 + 3
        System.out.println("rT: " + rT);  // 출력: 106

        // 🎯 3. 인자 3개: 병렬 스트림을 위한 누적 로직
        Integer rThr = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(100, Integer::sum, (x, y) -> x + y);
        System.out.println("rThr: " + rThr);  // 출력: 155 (100 + 1~10 합계)
    }
}
