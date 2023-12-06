package com.bookstoreVitor.bookstorevitorcosso.dtos.category.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryCreateDTO(
    @NotBlank(message = "field name must not be null or blank")
    @Size(min = 3, max=90,message = "field name must have a minimum length of 3 characters")
    String name, 
    
    @NotBlank
    @Size(min = 3, max=200, message = "field description must have a minimum length of 10 characters")
    String description) {
    
}
