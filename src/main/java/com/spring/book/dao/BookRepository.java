package com.spring.book.dao;

import com.spring.book.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findById(int id);
}
