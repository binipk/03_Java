package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.view.BookMenu;

public class Application {

    public static void main(String[] args) {
//        BookMenu bm = new BookMenu();
//        bm.menu();


        String text =
                """
                *** 도서 관리 프로그램 ***
                1. 도서 추가
                2. 도서 삭제
                3. 도서 검색
                4. 도서 출력
                5. 전체 보기
                6. 도서 정렬
                7. 도서 리스트 출력
                숫자를 입력해주세요 :
                """;

        System.out.println(text);
    }
}
