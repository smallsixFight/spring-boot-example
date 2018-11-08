package com.lamlake.example.mapper;

import com.lamlake.example.domain.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    List<Book> getAll();

    Book getById(int id);

    int insert(Book book);

    int delete(int id);

    int update(Book book);

}
