package com.bookstoreVitor.bookstorevitorcosso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
