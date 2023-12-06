package com.bookstoreVitor.bookstorevitorcosso.services.principalServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.get.CategoryGeneralDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.post.CategoryCreateDTO;
import com.bookstoreVitor.bookstorevitorcosso.repositories.CategoryRepository;
import com.bookstoreVitor.bookstorevitorcosso.services.bussinesRule.ValidatitionNameCategory;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CategoryService {
    
    @Autowired
    private ValidatitionNameCategory validatitionNameCategory;

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) throws Exception{
        return this.categoryRepository.findCategoryById(id).orElseThrow(() -> new Exception("Cant find the Category by the id: " + id));
    }

    public List<CategoryGeneralDTO> getListCategory(){ return this.categoryRepository.findAll().stream().map(CategoryGeneralDTO::new).toList(); }

    @Transactional
    public Category saveCategory(@Valid CategoryCreateDTO categoryCreateDTO) throws Exception {

        Category newCategory = createCategory(categoryCreateDTO);
        validatitionNameCategory.validate(newCategory);

        this.categoryRepository.save(newCategory);
        return newCategory;
    }


    private Category createCategory(@Valid CategoryCreateDTO categoryCreateDTO){
        
        return new Category(null, categoryCreateDTO.name(), categoryCreateDTO.description());
    }

    

}
