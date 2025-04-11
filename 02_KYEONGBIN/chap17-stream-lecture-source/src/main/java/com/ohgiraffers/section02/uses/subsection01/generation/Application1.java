package com.ohgiraffers.section02.uses.subsection01.generation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {

    public static void main(String[] args) {

        // 배열 순회 (기존 방식)
        String[] sarr = new String[]{"java", "mysql", "jdbc"};
        for(String s: sarr) {
            System.out.println(s);
        }

        System.out.println("==============================");

        // 배열 → 스트림 (전체)
        Stream<String> st1 = Arrays.stream(sarr);
        st1.forEach(System.out::println);

        System.out.println("==============================");

        // 배열 → 스트림 (일부: 시작 인덱스 0, 끝 인덱스 1 → 인덱스 0만 포함)
        Stream<String> st2 = Arrays.stream(sarr, 0, 1);
        st2.forEach(System.out::println);

        System.out.println("==============================");

        // 컬렉션 → 스트림
        List<String> sL = Arrays.asList("html", "css", "js");
        Stream<String> stream = sL.stream();
        stream.forEach(System.out::println);

        System.out.println("==============================");

        // 컬렉션은 스트림 없이도 forEach 사용 가능
        sL.forEach(System.out::println);

        System.out.println("==============================");

        // 빌더를 사용한 스트림 생성 (문자열)
        Stream<String> builderStream = Stream.<String>builder()
                .add("홍길동")
                .add("유관순")
                .add("윤봉길")
                .build(); // builder(): 요소를 수동으로 추가하고 스트림 생성
        builderStream.forEach(System.out::println);

        System.out.println("==============================");

        // 빌더를 사용한 스트림 생성 (정수)
        Stream<Integer> builderStream2 = Stream.<Integer>builder()
                .add(1)
                .add(2)
                .add(3)
                .build();
        builderStream2.forEach(System.out::println);

        System.out.println("==============================");

        // 반복 기반 스트림 생성 (초기값 10 → 다음 값은 이전 값 * 2 → 20개 생성)
        Stream<Integer> iS = Stream.iterate(10, value -> value * 2)
                .limit(20);
        iS.forEach(value -> System.out.print(value + " "));
    }
}
