package com.bookstoreVitor.bookstorevitorcosso.services.principalServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreVitor.bookstorevitorcosso.domain.Category;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.delete.CategoryDeleteDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.get.CategoryGeneralDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.post.CategoryCreateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.category.put.CategoryUpdateDTO;
import com.bookstoreVitor.bookstorevitorcosso.repositories.CategoryRepository;
import com.bookstoreVitor.bookstorevitorcosso.services.bussinesRule.ValidatitionNameCategory;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CategoryService {
    
    @Autowired
    private ValidatitionNameCategory validatitionNameCategory;

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) throws Exception{
        return this.categoryRepository.findCategoryById(id).orElseThrow(() -> new Exception("Cant find the Category by the id: " + id));
    }


    public Category getCategoryByName(String name) throws Exception{
        return this.categoryRepository.findCategoryByName(name).orElseThrow(() -> new Exception("Cant find the Category by the name: " + name));
    }

    public List<CategoryGeneralDTO> getListCategory(){ return this.categoryRepository.findAll().stream().map(CategoryGeneralDTO::new).toList(); }

    @Transactional
    public Category saveCategory(@Valid CategoryCreateDTO categoryCreateDTO) throws Exception {

        Category newCategory = createCategory(categoryCreateDTO);
        validatitionNameCategory.validate(newCategory);

        this.categoryRepository.save(newCategory);
        return newCategory;
    }

    @Transactional
    private Category createCategory(@Valid CategoryCreateDTO categoryCreateDTO){
        
        return new Category(null, categoryCreateDTO.name(), categoryCreateDTO.description());
    }


    @Transactional
    public Category updateCategory(@Valid CategoryUpdateDTO categoryUpdateDTO) throws Exception {
        Category categoryUpdate = getCategoryById(categoryUpdateDTO.id());

        if( categoryUpdateDTO.name() != null){
            categoryUpdate.setName(categoryUpdateDTO.name());
        }
        if( categoryUpdateDTO.description() != null){
            categoryUpdate.setDescription(categoryUpdateDTO.description());
        }

        return  categoryUpdate;
    }


    @Transactional
    public void deleteCategory(@Valid CategoryDeleteDTO categoryDeleteDTO) throws Exception {
      Category deletedCategory = null;

      if(categoryDeleteDTO.id() != null){
        deletedCategory = getCategoryById(categoryDeleteDTO.id());
        this.categoryRepository.delete(deletedCategory);
        return;
      }

      else if(categoryDeleteDTO.name() != null){
        deletedCategory = getCategoryByName(categoryDeleteDTO.name());
        this.categoryRepository.delete(deletedCategory);
        return;
      }

      throw new Exception("Not possible find any category with this id: +" + categoryDeleteDTO.id() +" or name: "+ categoryDeleteDTO.name());


    }

    

}
