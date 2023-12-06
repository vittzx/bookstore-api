package com.bookstoreVitor.bookstorevitorcosso.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bookstoreVitor.bookstorevitorcosso.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    public Optional<Category> findCategoryById(Long id);
    
    public Optional<Category> findCategoryByName(String name);

    public Boolean existsByName(String name);

}
