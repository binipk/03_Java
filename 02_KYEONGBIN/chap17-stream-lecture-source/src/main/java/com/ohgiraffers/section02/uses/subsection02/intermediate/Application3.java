package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {

        /*
         * ✅ flatMap은 "리스트 안에 리스트가 있는 구조(중첩 구조)"를
         * 평평하게(flat하게) 펴주는 메서드예요.
         *
         * 예를 들어:
         * [["a", "b"], ["c", "d"]] → ["a", "b", "c", "d"]
         *
         * map은 '변환'만 해주고,
         * flatMap은 '변환 + 펼치기(flattening)'를 같이 해줘요.
         */

        // 2차원 리스트 생성: List 안에 List 두 개가 들어있어요.
        List<List<String>> list = Arrays.asList(
                Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
                Arrays.asList("java", "spring", "spring-boot")
        );

        System.out.println("List (중첩 리스트): " + list);
        // 출력:
        // [[JAVA, SPRING, SPRINGBOOT], [java, spring, spring-boot]]

        // flatMap을 사용해 내부 리스트들을 하나의 스트림으로 평탄화(flatten)
        List<String> flatList = list.stream()
                .flatMap(Collection::stream)  // 각 내부 리스트를 펼쳐서 하나의 스트림으로
                .collect(Collectors.toList()); // 리스트로 다시 수집

        System.out.println("FlatList (평탄화 결과): " + flatList);
        // 출력:
        // [JAVA, SPRING, SPRINGBOOT, java, spring, spring-boot]
    }
}
