package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {
    private Scanner sc = new Scanner(System.in);
    private BookManager bm = new BookManager();

    public BookMenu() {}

    public void menu() {

//        public void addBook(BookDTO book) {
//        }
//
//        public void deleteBook(int index) {}
//
//        public void searchBook(String bTitle) {}
//
//        public void printBook(int index) {}
//
//        public void displayAll() {}
//
//        public ArrayList<BookDTO> sortedBookList(int select){}
//
//        public void printBookList(ArrayList<BookDTO> br){}
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

    }

    public BookDTO inputBook() {

    }

    public String inputBookTitle() {

    }




}
