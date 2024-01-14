package com.spring.book.Controller;

import com.spring.book.entities.Book;
import com.spring.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getBookList();
    }


//    get single book handler
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }


//    new book handler
    @PostMapping("/books")
    public Book addBook(@RequestBody  Book book) {
        return this.bookService.addBook(book);
    }


//    delete book handler
    @DeleteMapping("books/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        this.bookService.deleteBook(id);
        return "This book is deleted";
    }


//    update book handler
    @PutMapping("books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        this.bookService.updateBook(book, id);
        return book;
    }
}
