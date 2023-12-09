package com.bookstoreVitor.bookstorevitorcosso.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

    Optional<Book> findBookById(Long id);
    
}
