package com.bookstoreVitor.bookstorevitorcosso.dtos.category.put;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryUpdateDTO(

    @NotNull Long id,

    @Size(min = 3, max=90,message = "field name must have a minimum length of 3 characters") 
    String name, 

    @Size(min = 10, max=200, message = "field description must have a minimum length of 10 characters")
    String description) {
    
}
