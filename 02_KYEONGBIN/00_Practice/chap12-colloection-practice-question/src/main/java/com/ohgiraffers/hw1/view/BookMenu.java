package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);

    BookManager bm = new BookManager();

    public void menu() {

        System.out.println("도서 관리 프로그램");

        while (true) {

            System.out.println("--------------------");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서 정보");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 검색");
            System.out.println("5. 도서 전체 출력");
            System.out.println("6. 끝내기");
            System.out.println("--------------------");

            if (sc.nextInt() == 1) {
                bm.addBook(inputBook());
            }
            if (sc.nextInt() == 2) {
                bm.sortedBookList(sc.nextInt());
            }
            if (sc.nextInt() == 3) {
                System.out.println("삭제할 도서번호를 입력해 주세요: ");
                bm.deleteBook(sc.nextInt());
            }
            if (sc.nextInt() == 4) {
                bm.serchBook(sc.nextLine());
            }
            if (sc.nextInt() == 5) {
                bm.printBookList();
            }
        }
    }

    public BookDTO inputBook() {
        BookDTO book = new BookDTO();
        sc = new Scanner(System.in);
        System.out.println("도서 번호를 입력학세요: ");
        book.setTitle(sc.next());
        System.out.println("도서 제목을 입력하세요: ");
        book.setAuthor(sc.next());
        System.out.println("도서 카테고리를 입력하세요: ");
        book.setCategory(sc.nextInt());
        System.out.println("도서 저자를 입력하세요: ");
        book.setAuthor(sc.next());
        return book;
    }

    public String inputBookTitle() {
        return null;
    }





}
