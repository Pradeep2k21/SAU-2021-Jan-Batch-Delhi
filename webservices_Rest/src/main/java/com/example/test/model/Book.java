package com.example.test.model;

public class Book {
    private int id;
    private String bookname;
    private String authorName;

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return bookname;
    }

    public Book setName(String bookname) {
        this.bookname = bookname;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Book setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }
}
