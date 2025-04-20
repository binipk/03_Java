package com.ohgiraffers.operatorPractice;

import java.util.Scanner;

public class Application3 {

    public static void main(String[] args) {

        /*
         * 문자형 변수 하나를 선언하고 변수에 값이 M으로 초기화하면 남자입니다.
         * F이면 여성입니다를 출력하도록 작성하세요 (삼항연산자사용)
         *
         * M
         *
         * ---- 출력 결과 ---
         * 남자입니다.
         * */

         Scanner sc = new Scanner(System.in);

         while(true) {
            
            System.out.println("성별을 입력해 주세요! (M/F) \n'q'키를 눌러 종료합니다.");

            String input = sc.nextLine();

            if(input.equalsIgnoreCase("q")) {
                System.out.println("\nExiting the progream");
                break;
            }

            try {
                if(input.equalsIgnoreCase("m")) {
                    System.out.println("it's male.");
                } else if (input.equalsIgnoreCase("f")){
                    System.out.println("it's female.");
                } else {
                    System.out.println("Please enter M' or 'F'");
                }


            } catch (Exception e) {
            }

         }
         sc.close();

         
         





    }
}
