package com.ohgiraffers.lambda.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Application {

    public class App {
        public void test1() {
            // 실습문제 1
            // 현재시각 HH:mm:ss.SSS을 출력하는 람다식 작성
            Runnable currentTime = () ->
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
                currentTime.run();

            System.out.println("======================");

            Supplier<DateTimeFormatter> currentTime2 = () -> DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
            System.out.println(LocalDateTime.now().format(currentTime2.get()));

        }

        public void test2() {
            // 실습문제 2
            // 로또를 생성하는 람다식 작성 (리턴타입: Set<Integer>)
            IntSupplier lotto = () -> (int)(Math.random() * 45) + 1;
            


        }

        public void test3() {
            // 실습문제 3
            // 원화 입력 시 환율 계산을 통해 얻어진 달러 출력 (1달러 = 1350원)
        }

        public void test4() {
            // 실습문제 4
            // 위 문제를 JDK가 제공하는 Function 함수형 인터페이스 형식으로 변형
        }

        public void test5() {
            // 실습문제 5
            // 공백 제외 문자열의 길이가 0인지 체크하는 람다식
//            List<String> strList = Arrays.asList("abc", "", "대한민국", " ");
        }
    }

    public static void main(String[] args) {
        App app = new Application().new App();
        app.test1();
        app.test2();
        app.test3();
        app.test4();
        app.test5();
    }
}
