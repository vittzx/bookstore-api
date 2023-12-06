package com.bookstoreVitor.bookstorevitorcosso.infra.validations;

public class ValidationExceptionCategory extends RuntimeException {
    public ValidationExceptionCategory(String message){
        super(message);
    }
    
}
