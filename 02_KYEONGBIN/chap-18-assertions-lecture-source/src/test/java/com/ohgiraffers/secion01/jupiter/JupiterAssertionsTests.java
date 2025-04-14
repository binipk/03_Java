// 패키지 선언 - 이 클래스가 속한 폴더 경로
package com.ohgiraffers.secion01.jupiter;

// JUnit5에서 사용하는 Assertions 클래스 임포트 (테스트 시 결과 비교할 때 사용)
import org.junit.jupiter.api.Assertions;
// 테스트 설명용 애노테이션
import org.junit.jupiter.api.DisplayName;
// 테스트 메서드임을 표시하는 애노테이션
import org.junit.jupiter.api.Test;

// static import를 통해 Assertions 클래스의 메서드들을 클래스 이름 없이 바로 사용 가능하게 함


// Calculator 클래스에 대한 테스트를 수행하는 클래스
class JupiterAssertionsTests {

    // 1. assertEquals : 예상 값과 실제 값이 같은지 테스트 (같으면 테스트 통과)
    @Test // 이 메서드는 테스트 메서드임을 나타냄
    void testAssertEquals() {

        // given: 테스트할 데이터를 미리 준비
        int firstNum = 10;
        int secondNum = 20;
        int expectedNum = 29; // 실제 정답은 30이지만, 29로 설정해서 오차 범위 테스트

        // when: 실제 실행 로직
        Calculator c = new Calculator(); // Calculator 클래스 객체 생성
        int result = c.plus(firstNum, secondNum); // 10 + 20 = 30

        // then: 결과 확인 (검증)
        // assertEquals(예상값, 실제값, 허용 오차)
        // → 예상값과 실제값이 정확히 같진 않아도, 차이가 1 이하라면 OK
        Assertions.assertEquals(expectedNum, result, 1); // 통과 (30 - 29 = 1)

    }

    // 2. assertNull : 값이 null인지 확인하는 테스트
    @Test
    @DisplayName("Null test") // 테스트 실행 시 보여줄 이름
    void testAssertNull() {
        String str = null; // null 값 선언

        // str이 null인지 검사
        Assertions.assertNull(str); // null이면 통과

        // 아래 코드는 일부러 실패하는 테스트 예시 (주석 처리된 상태)
        // String str2 = "hello world";
        // Assertions.assertNull(str2); // null이 아니니까 실패!
    }

    // 3. assertAll : 여러 개의 검증을 한꺼번에 수행
    @Test
    void testAssertAll() {
        String firstName = "John";
        String lastName = "Doe";
        Person person = new Person(firstName, lastName); // Person 객체 생성

        // assertAll : 여러 assert를 묶어서 동시에 실행
        Assertions.assertAll(
                // 첫 번째 검증: 이름이 ""이어야 함 (틀림 → 실패)
                () -> Assertions.assertEquals("", person.getFirstName()),
                // 두 번째 검증: 성이 예상값과 같아야 함 (맞음 → 통과)
                () -> Assertions.assertEquals(lastName, person.getLastName())
        );
        // → 이 테스트는 첫 번째 조건이 실패하므로 전체 테스트 실패 처리됨
    }

    // 4. assertThrows : 특정 코드를 실행했을 때 예외(Exception)가 발생하는지 테스트
    @Test
    @DisplayName("exception 발생 테서트") // 테스트 설명
    void testAssertException() {

        // given: 테스트 데이터
        int firstNum = 10;
        int secondNum = 0; // 0으로 나눌 예정 → 예외 발생 조건

        // when, then: 예외 발생 테스트
        NumberValidation validator = new NumberValidation(); // 예외 체크용 클래스

        // assertThrows(예외클래스, 실행할 코드)
        // → 아래 코드가 실행되면서 IllegalAccessException이 발생하면 테스트 통과
        Exception exception = Assertions.assertThrows(
                IllegalAccessException.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );
    }
}
