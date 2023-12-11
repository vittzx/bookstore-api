package com.bookstoreVitor.bookstorevitorcosso.dtos.book.get;

import com.bookstoreVitor.bookstorevitorcosso.domain.Book;

public record BookGeneralDTO(String name, String autorship) {
    

    public BookGeneralDTO(Book book){
        this(book.getName(), book.getAutorship());
    }
}
