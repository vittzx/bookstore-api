package com.bookstoreVitor.bookstorevitorcosso.services.principalServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) throws Exception{
        return categoryRepository.findCategoryById(id).orElseThrow(() -> new Exception("Cant find the Category by the id: " + id));
    }

}