package com.bookstoreVitor.bookstorevitorcosso.services.principalServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;
import com.bookstoreVitor.bookstorevitorcosso.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getListBooks(){ return this.bookRepository.findAll(); }

    public Book getBookById(Long id) throws Exception{
        Book book = bookRepository.findBookById(id).orElseThrow(() -> new Exception("Cant find book by this id!"));
        return book;
    }
}
