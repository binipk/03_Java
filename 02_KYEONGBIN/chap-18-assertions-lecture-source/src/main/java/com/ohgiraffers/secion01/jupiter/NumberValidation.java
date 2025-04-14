package com.ohgiraffers.secion01.jupiter;

// 클래스 정의 시작
public class NumberValidation {

    // 클래스 안에 메서드를 올바르게 정의
    public void checkDividableNumbers(int firstNum, int secondNum) throws IllegalAccessException {
        if (secondNum == 0) {
            // 0으로 나눌 수 없다는 예외 발생
            throw new IllegalAccessException("0으로 나눌 수 없습니다.");
        }
    }
}
