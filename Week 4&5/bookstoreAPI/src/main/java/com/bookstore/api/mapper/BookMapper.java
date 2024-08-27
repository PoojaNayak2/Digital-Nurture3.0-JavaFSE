package com.bookstore.api.mapper;

import com.bookstore.api.dto.BookDTO;
import com.bookstore.api.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Book book);
    Book toBook(BookDTO bookDTO);
}
