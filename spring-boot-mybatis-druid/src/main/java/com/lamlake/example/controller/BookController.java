package com.lamlake.example.controller;

import com.lamlake.example.domain.entity.Book;
import com.lamlake.example.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/bookList")
    public List<Book> getAllBook() {
        return bookMapper.getAll();
    }
}
