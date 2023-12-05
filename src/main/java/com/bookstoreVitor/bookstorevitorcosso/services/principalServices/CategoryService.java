package com.bookstoreVitor.bookstorevitorcosso.services.principalServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.get.CategoryGeneralDTO;
import com.bookstoreVitor.bookstorevitorcosso.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) throws Exception{
        return categoryRepository.findCategoryById(id).orElseThrow(() -> new Exception("Cant find the Category by the id: " + id));
    }

    public List<CategoryGeneralDTO> getListCategory(){ return this.categoryRepository.findAll().stream().map(CategoryGeneralDTO::new).toList(); }

}
