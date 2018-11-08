package com.lamlake.example.domain.entity;

import lombok.Data;

@Data
public class Book {

    public Book() {}

    public Book(int bookId, String name, int number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

    private int bookId;
    private String name;
    private int number;
}
