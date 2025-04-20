package com.ohgiraffers.operatorPractice;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        /*
         * 임의의 정수 한개를 선언하고 해당 숫자가 13세 이하이면 어린이, 13세초과 ~ 19세 이하이면
         * 청소년, 19세 초과이면 성인이라고 출력되도록 작성하세요
         *
         * 19
         *
         * ------ 출력 결과 --------
         * 청소년
         * */

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your age: \nEnter 'q' to quit");
            String input = sc.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting the program!");
                break;
            }

            try {
                int age = Integer.parseInt(input);

                if (age <= 13 && age > 0) {
                    System.out.println("어린이");
                } else if (age > 13 && age <= 19) {
                    System.out.println("청소년");
                } else if (age > 19) {
                    System.out.println("성인");
                } else {
                    System.out.println("다시 입력해 주세요!!");
                } 
            } catch (NumberFormatException e) {
                System.out.println("다시 입력해 주세요!!");
            }



            
        }
        sc.close();









    }
}
