package com.ohgiraffers.section02.uses.subsection01.generation;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {

        // IntStream.range(시작, 끝): 시작부터 1씩 증가해서 '끝-1'까지 출력 (종료값 미포함)
        IntStream iS = IntStream.range(0, 5);
        iS.forEach(value -> System.out.print(value + " "));
        System.out.println();

        System.out.println("----------------------------------");

        // LongStream.rangeClosed(시작, 끝): 시작부터 1씩 증가해서 '끝'까지 출력 (종료값 포함)
        LongStream ls = LongStream.rangeClosed(5, 10);
        ls.forEach(value -> System.out.print(value + " "));

        System.out.println();

        // doubles(갯수): 난수를 생성해서 double 스트림으로 반환
        // boxed(): double → Double (객체 타입)으로 변환
        Stream<Double> dS = new Random().doubles(5).boxed();
        dS.forEach(value -> System.out.print(value + " "));

        System.out.println();

        // 문자열 "hello World"를 문자 단위로 쪼개서 IntStream으로 반환 (char값 → int)
        IntStream helloWorldChars = "hello World".chars();
        helloWorldChars.forEach(value -> System.out.print((char)value + " "));

        System.out.println();

        // 문자열을 구분자(", ")로 나눠서 스트림으로 변환
        Stream<String> sS = Pattern.compile(", ").splitAsStream("heml, css, js");

        // 문자열 배열처럼 직접 스트림 생성
        Stream<String> stS = Stream.of("heml", "css", "js");

        System.out.println();

        // 두 개의 스트림을 합쳐서 하나로 만들기 (동일한 타입일 때만 가능)
        Stream<String> stS2 = Stream.of("welcome", "to", "js");

        // 스트림은 1회성이라 sS, stS를 위에서 사용하면 다시 사용할 수 없음
        // 그래서 위에 주석 처리하고 concat만 실행
        Stream<String> ccS = Stream.concat(sS, stS2);
        ccS.forEach(value -> System.out.print(value + " "));
    }
}
