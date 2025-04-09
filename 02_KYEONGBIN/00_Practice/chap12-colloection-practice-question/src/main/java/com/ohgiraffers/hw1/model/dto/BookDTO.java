package com.ohgiraffers.hw1.model.dto;

public class BookDTO implements Comparable<BookDTO>{

    private int bNo;
    private int category;
    private String title;
    private String author;

    public BookDTO() {}

    public BookDTO(int bNo, int category, String title, String author) {
        this.bNo = bNo;
        this.category = category;
        this.title = title;
        this.author = author;
    }


    // -------------------- Setter & Getter --------------------

    public int getbNo() {
        return bNo;
    }
    public void setbNo(int bNo) {
        this.bNo = bNo;
    }
    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // -------------------- Output section --------------------

    public String toString() {
        int bNo = getbNo();
        int category = getCategory();
        String title = getTitle();
        String author = getAuthor();
        return "도서번호: " + bNo
                + ", 도서분류코드: " + category
                + ", 도서제목: " + title
                + ", 도서저자: " + author;
    }

    @Override
    public int compareTo(BookDTO o) {
        return 0;
    }
}
