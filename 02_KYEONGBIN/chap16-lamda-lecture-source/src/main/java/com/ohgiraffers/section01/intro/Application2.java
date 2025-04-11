package com.ohgiraffers.section01.intro;

public class Application2 {
    public static void main(String[] args) {

        OuterCalculator.Sum sum = (x, y) -> x + y; // 기능(구현체) 구성
        System.out.println("Sum of 10 and 20: " + (sum.sumTwoNumber(10, 20)));

        OuterCalculator.Minus minus = (x, y) -> x - y;
        System.out.println("Minus of 10 and 20: " + (minus.minusTwoNumber(10, 20)));

        OuterCalculator.Multiple multiple = (x, y) -> x * y;
        System.out.println("Multiple of 10 and 20: " + (multiple.multipleTwoNumber(10, 20)));

        OuterCalculator.Devide devide = (x, y) -> x / y;
        System.out.println("division of 10 and 20: " + (devide.divideTwoNumber(10, 20)));


    }
}
