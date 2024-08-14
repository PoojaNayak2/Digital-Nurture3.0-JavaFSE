package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter method for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.save(new Book(title));
    }

    public void listBooks() {
        bookRepository.findAll().forEach(System.out::println);
    }
}
