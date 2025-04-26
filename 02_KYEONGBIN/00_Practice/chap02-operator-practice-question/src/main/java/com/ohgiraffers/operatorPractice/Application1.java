package com.ohgiraffers.operatorPractice;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {

        /*
         * 임의의 정수를 하나 선언하고 선언한 숫자가 짝수이면 "짝수다", 짝수가 아니면
         * "홀수다"를 출력하세요
         *
         * ------- 출력 결과 화면 ----------
         *
         * 예)정수 9를 선언했을 경우
         *
         * 홀수
         * */

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter number: \n(Enter 'q' to quit");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting program!");
                break;
            }

            try {
                int num = Integer.parseInt(input);
                if (num % 2 == 0 && num > 0) {
                    System.out.println("The number is even");

                } else if (num % 2 != 0 && num > 0) {
                    System.out.println("The number is odd");

                } else if (num < 0) {
                    System.out.println("The number cannot be negative!");
                } else {
                    System.out.println("Please enter the correct number");
                }

            } catch (Exception e) {
                System.out.println("Please enter the correct number");

            }
        }
        sc.close();


        

    }
}
