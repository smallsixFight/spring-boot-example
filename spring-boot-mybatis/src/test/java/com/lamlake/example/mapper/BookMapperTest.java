package com.lamlake.example.mapper;

import com.lamlake.example.Application;
import com.lamlake.example.domain.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testQueryAll() {
        List<Book> list = bookMapper.getAll();
        System.out.println(list);
    }

    @Test
    public void testQueryOne() {
        Book book = bookMapper.getById(1000);
        System.out.println(book.toString());
    }

    @Test
    public void testInsert() {
        Book book = new Book(5000, "Golang 开发实战", 9);
        int i = bookMapper.insert(book);
        System.out.println("i --> " + i);
    }

    @Test
    public void testDelete() {
        int i = bookMapper.delete(5000);
        System.out.println("i --> " + i);
    }

    @Test
    public void testUpdate() {
        Book book = new Book(5000, "Golang 开发实战", 10);
        int i = bookMapper.update(book);
        System.out.println("i --> " + i);
    }

}