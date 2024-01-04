package com.bookstoreVitor.bookstorevitorcosso.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.delete.CategoryDeleteDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.get.CategoryGeneralDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.get.CategorySingleDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.post.CategoryCreateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.put.CategoryUpdateDTO;
import com.bookstoreVitor.bookstorevitorcosso.services.principalServices.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<CategorySingleDTO> createCategory(@RequestBody @Valid CategoryCreateDTO categoryCreateDTO, UriComponentsBuilder uribuilder) throws Exception{
        Category newCategory = this.categoryService.saveCategory(categoryCreateDTO);
        URI uri = uribuilder.path("/category/{id}").buildAndExpand(newCategory.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategorySingleDTO(newCategory));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public ResponseEntity<CategorySingleDTO> updateCategory(@RequestBody @Valid CategoryUpdateDTO categoryUpdateDTO) throws Exception{

        Category updateCategory = this.categoryService.updateCategory(categoryUpdateDTO);
        return new ResponseEntity<>(new CategorySingleDTO(updateCategory),HttpStatus.OK);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public ResponseEntity<String> deleteCategory(@RequestBody @Valid CategoryDeleteDTO categoryDeleteDTO) throws Exception{
        this.categoryService.deleteCategory(categoryDeleteDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    
}
