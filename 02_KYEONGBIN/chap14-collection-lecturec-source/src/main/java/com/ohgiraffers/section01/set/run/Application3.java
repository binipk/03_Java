package com.ohgiraffers.section01.set.run;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {

    public static void main(String[] args) {

        // 문자열 TreeSet (자동 정렬됨)
        TreeSet<String> lSet = new TreeSet<>();
        Set<String> tSet = new TreeSet<>();

        tSet.add("java");
        tSet.add("c");
        tSet.add("c++");
        tSet.add("html");
        tSet.add("Css");

        System.out.println("tSet: " + tSet);               // 알파벳 순으로 정렬됨
        System.out.println("size of tSet: " + tSet.size()); // 크기 확인
        System.out.println("lSet (비어있음): " + lSet);

        // 로또 번호 생성 (1 ~ 45 중 중복 없이 6개)
        Set<Integer> lotto = new TreeSet<>();

        while (lotto.size() < 6) {
            lotto.add((int)(Math.random() * 45) + 1);
        }

        System.out.println("Lotto numbers: " + lotto); // 자동 정렬된 상태로 출력
    }
}
