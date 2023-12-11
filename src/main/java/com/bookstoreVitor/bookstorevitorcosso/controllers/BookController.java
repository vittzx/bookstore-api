package com.bookstoreVitor.bookstorevitorcosso.controllers;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.BookGeneralDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.post.BookCreateDTO;
import com.bookstoreVitor.bookstorevitorcosso.services.principalServices.BookService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/category/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) throws Exception{
        Book book = bookService.getBookById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getListBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookGeneralDTO> createBook(@RequestBody @Valid BookCreateDTO bookCreateDTO, @RequestParam(value="category", defaultValue = "0") Long category_id, UriComponentsBuilder uriBuilder) throws Exception{

        Book newBook = bookService.createBook(bookCreateDTO,category_id);
        URI uri = uriBuilder.path("/category/book/{id}").buildAndExpand(newBook.getId()).toUri();
        return ResponseEntity.created(uri).body(new BookGeneralDTO(newBook));
    }
    
}
