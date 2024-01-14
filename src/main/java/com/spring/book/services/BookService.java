package com.spring.book.services;

import com.spring.book.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private static List<Book> bookList = new ArrayList<>();

    static {
//        bookList.add(new Book(141, "boot","Monayem"));
//        bookList.add(new Book(142, "Spring","Monayem"));
//        bookList.add(new Book(143, "ORM","Monayem"));
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Book getBookById(int id) {
        Book book = null;
        book = bookList.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    public Book addBook(Book book) {
        bookList.add(book);
        return book;
    }

    public void deleteBook(int id) {
        bookList = bookList.stream().filter( book -> book.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(Book book, int id) {
        bookList = bookList.stream().map(b -> {
            if (b.getId() == id) {
                return book;
            } else {
                return b;
            }
        }).collect(Collectors.toList());
    }
}
