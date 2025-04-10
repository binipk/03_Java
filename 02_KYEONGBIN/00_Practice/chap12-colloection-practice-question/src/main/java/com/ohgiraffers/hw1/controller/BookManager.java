package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;

public class BookManager {

    private ArrayList<BookDTO> bookList = new ArrayList<>();

    public void addBook(BookDTO book) {
        bookList.add(book);
        System.out.println("입력하신 도서가 정상적으로 추가되었습니다. ^^");
        System.out.println(book);
    }

    public void deleteBook(int index) {
        for (int i = 0; i <bookList.size(); i++) {
            if (bookList.get(i).getbNo() == index) {
                bookList.remove(i);
            }
        }

    }

    public int serchBook(String bTitle) {
        int i;
        System.out.println("도서 제목을 입력해주세요.");
        for (i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equals(bTitle)) {
            }
        } return bookList.get(i).getbNo();
    }

    public void printBook(int index) {}

    public void displayAll() {}

    public ArrayList<BookDTO> sortedBookList(int i) {

        while (true) {
            System.out.println("""
                정렬 방식을 선택해 주세요:
                1. 오름차순
                2. 내림차순
                0. 이전 메뉴로 돌아가기""");

            int select = i;

            if (select == 1) {
                Collections.sort(bookList);
                return bookList;
            } else if (select == 2) {
                Collections.sort(bookList, Collections.reverseOrder());
                return bookList;
            } else if (select == 0) {
                System.out.println("이전 메뉴로 돌아갑니다.");
                return null;
            } else {
                System.out.println("잘못 입력하였습니다. 다시 선택해 주세요.");
            }
        }
    }

    public void printBookList(ArrayList<BookDTO> br) {}

    public ArrayList<BookDTO> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<BookDTO> bookList) {
        this.bookList = bookList;
    }
}
