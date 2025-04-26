package com.ohgiraffers.section01.level02.normal;

import java.util.Arrays;

public class Application4 {

    public static void main(String[] args) {
        int[] lotto = new int[7];
        for(int i = 0; i < 7; i++){
            lotto[i] = (int) (Math.random()*45+1);
        }
        System.out.println("이번 주 로또 번호는 : " + Arrays.toString(lotto));
     /*
		  로또 번호 자동 생성기 프로그램을 작성하세요.
		  단, 중복 값 없이

		  Random 클래스 사용 혹은 Math.random() 메소드를 사용
	   */
    }
}
