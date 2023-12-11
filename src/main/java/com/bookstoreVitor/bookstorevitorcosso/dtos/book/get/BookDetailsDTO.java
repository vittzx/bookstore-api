package com.bookstoreVitor.bookstorevitorcosso.dtos.book.get;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;

public record BookDetailsDTO(Long id, String name, String autorship, String description) {

    public BookDetailsDTO(Book book){
        this(book.getId(), book.getName(), book.getAutorship(), book.getDescription());
    }
}
