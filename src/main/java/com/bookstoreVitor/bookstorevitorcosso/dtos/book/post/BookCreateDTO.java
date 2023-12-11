package com.bookstoreVitor.bookstorevitorcosso.dtos.book.post;

import jakarta.validation.constraints.NotBlank;

public record BookCreateDTO(@NotBlank String name, @NotBlank String autorship, @NotBlank String description ) {
    
}
