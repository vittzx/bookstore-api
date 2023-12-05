package com.bookstoreVitor.bookstorevitorcosso.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;
import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.repositories.BookRepository;
import com.bookstoreVitor.bookstorevitorcosso.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class DBService{
    

    @Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;


    
	@Transactional
	public void dataBaseInstance(){
		Category category1 = new Category(null, "Computing", "Books of computing");
		Book book1 = new Book (null,"Clean Code", "Robert Martion", "Good Pratices with writing a code",category1);
		category1.getBooks().addAll(Arrays.asList(book1));
		bookRepository.saveAll(Arrays.asList(book1));
		categoryRepository.saveAll(Arrays.asList(category1));
	}
}
