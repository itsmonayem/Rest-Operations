package com.spring.book.services;

import com.spring.book.dao.BookRepository;
import com.spring.book.entities.Book;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getBookList() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            book = this.bookRepository.findById(126);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(int id) {
//        bookList = bookList.stream().filter( book -> book.getId() != id).collect(Collectors.toList());
        this.bookRepository.deleteById(id);
    }

    public void updateBook(Book book, int id) {
        book.setId(id);
        this.bookRepository.save(book);
    }
}
