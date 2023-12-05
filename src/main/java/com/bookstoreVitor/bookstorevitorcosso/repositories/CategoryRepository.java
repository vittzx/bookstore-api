package com.bookstoreVitor.bookstorevitorcosso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
