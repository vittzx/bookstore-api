package com.bookstoreVitor.bookstorevitorcosso.dtos.category.get;

import java.util.List;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.get.BookDetailsDTO;


public record CategorySingleDTO(Long id, String name, String description, List<BookDetailsDTO> books) {

    public CategorySingleDTO(Category category){
        this(category.getId(), category.getName(), category.getDescription(), category.getBooks().stream().map(BookDetailsDTO::new).toList());
    }
    
}
