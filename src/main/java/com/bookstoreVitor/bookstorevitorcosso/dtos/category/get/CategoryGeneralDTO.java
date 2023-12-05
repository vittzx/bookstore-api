package com.bookstoreVitor.bookstorevitorcosso.dtos.category.get;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;

public record CategoryGeneralDTO(Long id,String name, String description) {
    
    public CategoryGeneralDTO(Category category){
        this(category.getId() ,category.getName(), category.getDescription());
    }
}
