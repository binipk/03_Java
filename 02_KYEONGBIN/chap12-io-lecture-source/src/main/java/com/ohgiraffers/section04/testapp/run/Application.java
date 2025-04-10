package com.ohgiraffers.section04.testapp.run;

import com.ohgiraffers.section04.testapp.service.MemberService;

import java.util.Scanner;

public class Application {

    private static final MemberService memberService = new MemberService();
    // Global
    // 여기서만 쓸거라 private (외부 노출 방지)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String menu = """
                ========== 회원 관리 프로그램 ==========
                1. 모든 회원 정보 보기
                2. 회원 찾기
                3. 회원 가입
                4. 회원 정보 수정
                5. 회원 탈퇴
                0. 프로그램 종료
                메뉴를 선택해주세요: """;

        while(true) {
            System.out.println(menu);
            int intput = sc.nextInt();

            switch(intput) {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 0: break;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }







    }
}
