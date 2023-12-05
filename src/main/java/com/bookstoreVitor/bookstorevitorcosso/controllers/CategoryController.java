package com.bookstoreVitor.bookstorevitorcosso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.get.CategoryGeneralDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.get.CategorySingleDTO;
import com.bookstoreVitor.bookstorevitorcosso.services.principalServices.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @GetMapping("/{id}")
    public ResponseEntity<CategorySingleDTO> getCategoryById(@PathVariable Long id) throws Exception{
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(new CategorySingleDTO(category),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryGeneralDTO>> getAllCategories(){
        List<CategoryGeneralDTO> categoriesDTO = this.categoryService.getListCategory();
        return new ResponseEntity<>(categoriesDTO ,HttpStatus.OK);

    }
}
