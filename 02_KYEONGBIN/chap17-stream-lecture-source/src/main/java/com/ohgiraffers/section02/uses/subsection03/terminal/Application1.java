package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {

        /*
         * ✅ Terminal Operation(종결 처리)
         * 스트림의 마지막 단계에서 데이터를 "결과로 만들고 끝내는" 작업이에요.
         *
         * 여기서는 숫자 스트림에 대해 다양한 집계 작업(count, sum, max, min 등)을 해요.
         */

        // 1부터 9까지 숫자의 개수 세기 (총 9개)
        long count = IntStream.range(1, 10).count();

        // 1부터 9까지의 합
        long sum = IntStream.range(1, 10).sum();

        System.out.println("count: " + count); // 출력: count: 9
        System.out.println("sum: " + sum);     // 출력: sum: 45

        // 최대값과 최소값 구하기 (OptionalInt로 반환됨)
        OptionalInt max = IntStream.range(1, 10).max();
        OptionalInt min = IntStream.range(1, 10).min();

        System.out.println("max: " + max.getAsInt()); // 출력: max: 9
        System.out.println("min: " + min.getAsInt()); // 출력: min: 1

        // 홀수만 골라서 합계 구하기 (1 + 3 + 5 + 7 + 9 = 25)
        int oddSum = IntStream.range(1, 10)
                .filter(i -> i % 2 == 1)
                .sum();
        System.out.println("oddSum: " + oddSum); // 출력: oddSum: 25
    }
}
