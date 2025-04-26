package com.ohgiraffers.level02.normal;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        /* 국어점수 80.5점, 수학점수 50.6점, 영어점수 70.8점을 실수 형태로 저장한 뒤
         * 총점과 평균을 정수 형태로 출력하세요
         *
         * -- 출력 예시 --
         * 총점 : 201
         * 평균 : 67
         *  */

//        double korean = 80.5;
//        double math = 50.6;
//        double english = 70.8;
//        int sum = (int) (korean + math + english);
//        int avgScore = sum / 3;
//        System.out.println("총점: " + sum);
//        System.out.println("평균점수: " + avgScore);

               Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease enter your score of the Korean: \n(Enter 'q' to quit!)");
            String korean = sc.nextLine();

            if (korean.equalsIgnoreCase("q")) {
                System.out.println("\n====================");
                System.out.println("Exiting program!");
                System.out.println("====================");
                break;
            }

            System.out.println("Please enter your score of the Mathematics: \n(Enter 'q' to quit!)");
            String math = sc.nextLine();

            if (math.equalsIgnoreCase("q")) {
                System.out.println("\n====================");
                System.out.println("Exiting program!");
                System.out.println("====================");
                break;
            }

            System.out.println("Please enter your score of the English: \n(Enter 'q' to quit!)");
            String english = sc.nextLine();

            if (english.equalsIgnoreCase("q")) {
                System.out.println("\n====================");
                System.out.println("Exiting program!");
                System.out.println("====================");
                break;
            }

            try {
                double koreanScore = Double.parseDouble(korean);
                double mathScore = Double.parseDouble(math);
                double englishScore = Double.parseDouble(english);

                if (koreanScore < 0 || koreanScore > 100) {
                    System.out.println("Enter the correct score!");
                } else if (mathScore < 0 || mathScore > 100) {
                    System.out.println("Enter the correct score!");
                } else if (englishScore < 0 || englishScore > 100) {
                    System.out.println("Enter the correct score!");
                } else {
                    int sumScore = (int) (koreanScore + mathScore + englishScore);
                    int avgScore = (int) (sumScore) / 3;
                    System.out.println("\n====================");
                    System.out.println("총점: " + sumScore);
                    System.out.println("평균 점수: " + avgScore);
                    System.out.println("====================");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter the correct score!");
            }
        }

        sc.close();


    }
}
