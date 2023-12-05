package com.bookstoreVitor.bookstorevitorcosso.services.dbService;

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
		Category category2 = new Category(null, "Science", "Books about science , physics, biology");
		Category category3 = new Category(null, "Fashion", "Books of fashion");
		Category category4 = new Category(null, "History", "Books of human history");


		Book book1 = new Book(null,"Clean Code", "Robert Martion", "Good Pratices with writing a code",category1);
		Book book2 = new Book(null,"Java: The Comprehensive Guide", "Christian Ullenboom", "Java guide for begginers",category1);
		Book book3 = new Book(null, "Scientific Discoveries", "Jane Scientist", "Exploring the wonders of science", category2);
		Book book4 = new Book(null, "Einstein's Legacy", "Albert Biographer", "Understanding physics through history", category2);
		Book book5 = new Book(null, "Fashion Forward", "Style Guru", "Trends and insights in the world of fashion", category3);
		Book book6 = new Book(null, "The Art of Dressing", "Fashionista Author", "Creating a stylish wardrobe", category3);
		Book book7 = new Book(null, "Chronicles of Civilization", "Historian Author", "Journey through human history", category4);
		Book book8 = new Book(null, "Historical Perspectives", "History Buff", "Insights into key historical events", category4);
		category1.getBooks().addAll(Arrays.asList(book1, book2));
		category2.getBooks().addAll(Arrays.asList(book3,book4));
		category3.getBooks().addAll(Arrays.asList(book5, book6));
		category4.getBooks().addAll(Arrays.asList(book7,book8));
		
		bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4,book5,book6,book7,book8));
		categoryRepository.saveAll(Arrays.asList(category1,category2,category3,category4));
	}
}
