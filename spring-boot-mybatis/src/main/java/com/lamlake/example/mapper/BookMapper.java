package com.lamlake.example.mapper;

import com.lamlake.example.domain.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Select("SELECT * FROM book")
    @Results({
        @Result(property = "bookId", column = "book_id")
    })
    List<Book> getAll();

    @Select("SELECT * FROM book WHERE book_id=#{id}")
    @Results({
            @Result(property = "bookId", column = "book_id")
    })
    Book getById(int id);

    @Insert("INSERT INTO book values(#{bookId}, #{name}, #{number})")
    int insert(Book book);

    @Delete("DELETE FROM book WHERE book_id=#{id}")
    int delete(int id);

    @Update("UPDATE book set number=#{number} WHERE book_id=#{bookId}")
    int update(Book book);

}
