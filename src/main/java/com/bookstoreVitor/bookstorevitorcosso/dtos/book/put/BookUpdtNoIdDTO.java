package com.bookstoreVitor.bookstorevitorcosso.dtos.book.put;

import jakarta.validation.constraints.Size;

public record BookUpdtNoIdDTO(    
    
@Size(min = 3, max=90,message = "field name must have a minimum length of 3 characters")    
    String name, 
    @Size(min = 5, max=200, message = "field autorship must have a minimum length of 5 characters")
    String autorship, 
    @Size(min = 10, max=200, message = "field description must have a minimum length of 10 characters")
    String description) {
    

}
