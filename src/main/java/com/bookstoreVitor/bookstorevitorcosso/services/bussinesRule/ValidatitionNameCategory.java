package com.bookstoreVitor.bookstorevitorcosso.services.bussinesRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.infra.validations.ValidationExceptionCategory;
import com.bookstoreVitor.bookstorevitorcosso.repositories.CategoryRepository;

@Component
public class ValidatitionNameCategory implements BussinesRule{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void validate(Category category) throws Exception {
        if(categoryRepository.existsByName(category.getName())){
            category = null;
            throw new ValidationExceptionCategory("Already exists a category with this name");
        }
        
    }
    
}
