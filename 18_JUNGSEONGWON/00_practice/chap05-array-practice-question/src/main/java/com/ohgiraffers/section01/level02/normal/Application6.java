package com.ohgiraffers.section01.level02.normal;

import java.util.Scanner;

public class Application6 {

    public static void main(String[] args) {
        String[] sArr = new String[3];
        sArr[0] = "양념";
        sArr[1] = "뿌링클";
        sArr[2] = "후라이드";
        Scanner sc = new Scanner(System.in);
        System.out.println("치킨 이름을 입력하세요 : ");
        String input = sc.nextLine();


        boolean able = false;

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals(input)) {
                able = true;
                break;
            }
        }if (able == true) {
            System.out.println(input + " 치킨 배달 가능");

        }else {
            System.out.println(input + " 치킨 배달 불가능");
        }
        /*
         * 사용자가 입력한 값이 배열에 있는지 검색하여
         * 있으면 "OOO 치킨 배달 가능", 없으면 "OOO 치킨은 없는 메뉴입니다."를
         * 출력하세요.
         * 단, 치킨메뉴가 들어가 있는 배열은 본인이 스스로 정하세요
         *
         * ex.
         * 치킨 이름을 입력하세요 : 양념     치킨 이름을 입력하세요 : 불닭
         * 양념치킨 배달 가능              불닭치킨은 없는 메뉴입니다.
         * */

    }
}
