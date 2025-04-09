package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);

    BookManager bm = new BookManager();

    public BookMenu() {}

    public void menu() {}
    
    public BookDTO inputBook() {
        BookDTO book = new BookDTO();
        book.setTitle(sc.next());
        book.setAuthor(sc.next());
        book.setCategory(sc.nextInt());
        return book;
    }




}
