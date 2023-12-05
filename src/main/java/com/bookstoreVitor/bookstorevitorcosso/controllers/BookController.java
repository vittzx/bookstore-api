package com.bookstoreVitor.bookstorevitorcosso.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;
import com.bookstoreVitor.bookstorevitorcosso.repositories.BookRepository;
import com.bookstoreVitor.bookstorevitorcosso.repositories.CategoryRepository;

@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookRepository.getReferenceById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
}
