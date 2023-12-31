package com.bookstoreVitor.bookstorevitorcosso.services.principalServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;
import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.post.BookCreateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.put.BookUpdateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.put.BookUpdtNoIdDTO;
import com.bookstoreVitor.bookstorevitorcosso.repositories.BookRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;


    public List<Book> getListBooks(){ return this.bookRepository.findAll(); }

    public Book getBookById(Long id) throws Exception{
        Book book = bookRepository.findBookById(id).orElseThrow(() -> new Exception("Cant find book by this id!"));
        return book;
    }


    @Transactional
    public Book createBook(@Valid BookCreateDTO bookCreateDTO, Long category_id) throws Exception {
        Category categoryBook = categoryService.getCategoryById(category_id);
        Book newBook =  new Book(bookCreateDTO, categoryBook);
        categoryService.addBookCategory(categoryBook, newBook);
        bookRepository.save(newBook);
        return newBook;
    }


    @Transactional
    public Book updateBook(@Valid BookUpdateDTO bookUpdateDTO) throws Exception{
        Book updateBook = getBookById(bookUpdateDTO.id());

        updateBook.updateBook(bookUpdateDTO);

        return updateBook;
    }


    @Transactional
    public Book updateBookById(@Valid BookUpdtNoIdDTO bookUpdtNoIdDTO, Long id) throws Exception {
        Book updateBook = getBookById(id);

        updateBook.updateBook(bookUpdtNoIdDTO);
        
        return updateBook;
    }

    public void deleteBook(Long id) throws Exception{
        Book deletedBook = getBookById(id);
        this.bookRepository.delete(deletedBook);
    }



}
