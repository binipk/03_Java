package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {

    public static void main(String[] args) {

        // Member 객체를 담은 리스트 생성
        List<Member> memberList = Arrays.asList(
                new Member("test01", "testName01"),
                new Member("test02", "testName02"),
                new Member("test03", "testName03")
        );

        // 전체 Member 객체 출력
        for (Member m : memberList) {
            System.out.println(m);
        }

        // --------------------------------------
        // 1. 전통 방식: name만 꺼내서 새 리스트 만들기
        List<String> stringList = new ArrayList<>();
        for (Member member : memberList) {
            stringList.add(member.getName());
        }

        // name 리스트 출력
        for (String s : stringList) {
            System.out.println(s);
        }

        // --------------------------------------
        // 2. Stream 사용: name만 추출해서 리스트로 수집
        List<String> collectorCollection = memberList.stream()
                .map(Member::getName)                         // name만 추출
                .collect(Collectors.toList());                // 리스트로 수집

        for (String s : collectorCollection) {
            System.out.println(s);
        }

        // --------------------------------------
        // 3. name들을 하나의 문자열로 연결 (구분자 없이)
        String str = memberList.stream()
                .map(Member::getName)
                .collect(Collectors.joining());               // 구분자 없음

        // 문자열을 ,로 나눈 후 출력 (실제로 ,는 없지만 형식 맞춤)
        for (String s : str.split(",")) {
            System.out.println(s);
        }

        // --------------------------------------
        // 4. 문자열 연결 + 구분자 "," + 접두사/접미사 추가
        String str2 = memberList.stream()
                .map(Member::getName)
                .collect(Collectors.joining(",", "❤️", "🥩")); // "," 구분, 앞❤️ 뒤🥩

        for (String s : str2.split(",")) {
            System.out.println(s);
        }
    }
}
