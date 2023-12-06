package com.bookstoreVitor.bookstorevitorcosso.services.bussinesRule;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;

public interface BussinesRule {
    public void validate(Category category) throws Exception;
}
