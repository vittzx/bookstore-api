package com.bookstoreVitor.bookstorevitorcosso.controllers;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.get.BookDetailsDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.get.BookGeneralDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.post.BookCreateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.put.BookUpdateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.put.BookUpdtNoIdDTO;
import com.bookstoreVitor.bookstorevitorcosso.services.principalServices.BookService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/category/book")
@CrossOrigin("http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) throws Exception{
        Book book = bookService.getBookById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getListBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<BookGeneralDTO> createBook(@RequestBody @Valid BookCreateDTO bookCreateDTO, @RequestParam(value="category", defaultValue = "0") Long category_id, UriComponentsBuilder uriBuilder) throws Exception{

        Book newBook = bookService.createBook(bookCreateDTO,category_id);
        URI uri = uriBuilder.path("/category/book/{id}").buildAndExpand(newBook.getId()).toUri();
        return ResponseEntity.created(uri).body(new BookGeneralDTO(newBook));
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public ResponseEntity<BookDetailsDTO> updateBook(@RequestBody @Valid BookUpdateDTO bookUpdateDTO) throws Exception{
        Book updateBook = bookService.updateBook(bookUpdateDTO);
        return new ResponseEntity<>(new BookDetailsDTO(updateBook),HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> updateBookById(@RequestBody @Valid BookUpdtNoIdDTO bookUpdtNoIdDTO , @PathVariable Long id) throws Exception{
        Book updateBook = bookService.updateBookById(bookUpdtNoIdDTO, id);
        return new ResponseEntity<>(new BookDetailsDTO(updateBook),HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) throws Exception{
        this.bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
