package com.bookstoreVitor.bookstorevitorcosso.dtos.exceptions;

import org.springframework.validation.FieldError;

public record ErrorDTO(String message, String status) {
    
    public ErrorDTO(String message){
        this(message, "404");
    }

    public ErrorDTO(Exception e){
        this(e.getMessage(),"500");
    }

    public ErrorDTO(FieldError error) {
        this(error.getDefaultMessage(), error.getField());
    }


}
