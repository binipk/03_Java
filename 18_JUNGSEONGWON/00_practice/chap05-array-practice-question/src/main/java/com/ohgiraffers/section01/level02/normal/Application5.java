package com.ohgiraffers.section01.level02.normal;

import java.util.Scanner;

public class Application5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 입력
        System.out.print("문자열을 하나 입력하세요: ");
        String input = sc.nextLine();

        // 문자 배열로 변환
        char[] charArray = input.toCharArray();

        // 찾고자 하는 문자 입력
        System.out.print("찾고자 하는 문자를 입력해주세요: ");
        char ch = sc.next().charAt(0);

        // 문자 개수 세기
        int count = 0;
        for (char c : charArray) {
            if (c == ch) {
                count++;
            }
        }

        // 결과 출력
        System.out.println("입력하신 문자열 " + input + "에서 찾으시는 문자 '" + ch + "'는 " + count + "개 입니다.");
    }
        /*
         * 문자열을 입력받아 문자 하나하나를 배열에 넣고 검색할 문자가
         * 문자열에 몇 개 들어가 있는지 개수와 몇 번째 인덱스에 위치하는지
         * 인덱스를 출력하세요.
         *
         * ex.
         *	문자열 : application
         *	문자 : i
         *	application에 i가 존재하는 위치(인덱스) : 4 8
         *	i 개수 : 2
         * */
    }
