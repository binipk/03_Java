package com.ohgiraffers.section01.literal;

public class Application1 {

    public static void main(String[] args) {

        // 문자열 출력
        System.out.println("Hello World!");       // 큰따옴표로 묶인 문자열 출력

        // 정수 출력
        System.out.println(123);                  // 정수 리터럴 출력

        // 실수 출력
        System.out.println(1.234);                // 실수 리터럴 출력

        // 문자 출력
        System.out.println('a');                  // 문자 리터럴 출력 (작은따옴표 사용)
        System.out.println('1');                  // 숫자처럼 보여도 문자 리터럴 (문자 '1')
        System.out.println('\u0000');             // 유니코드 문자 출력 (널 문자)

        // System.out.println('');                // 오류 발생: 빈 문자는 사용할 수 없음

        // 문자열 출력
        System.out.println("안녕하세요");           // 문자열 리터럴 (한글도 출력 가능)
        System.out.println("a");                  // 문자열로서의 'a' (문자와는 다름)
        System.out.println("");                   // 빈 문자열 출력

        // 논리값 출력
        System.out.println(true);                 // boolean 리터럴 true
        System.out.println(false);                // boolean 리터럴 false
        System.out.println("true");               // 문자열 "true" (논리값 아님)
    }
}
