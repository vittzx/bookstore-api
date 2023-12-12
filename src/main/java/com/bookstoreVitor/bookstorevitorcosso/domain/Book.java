package com.bookstoreVitor.bookstorevitorcosso.domain;


import com.bookstoreVitor.bookstorevitorcosso.dtos.book.post.BookCreateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.put.BookUpdateDTO;
import com.bookstoreVitor.bookstorevitorcosso.dtos.book.put.BookUpdtNoIdDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public Book(@Valid BookCreateDTO bookCreateDTO, Category category) {
        this.name = bookCreateDTO.name();
        this.autorship = bookCreateDTO.autorship();
        this.description = bookCreateDTO.description();
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String autorship;
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id" )
    private Category category;



    public void updateBook(BookUpdateDTO bookUpdateDTO){
        if(bookUpdateDTO.name() != null){
            this.setName(bookUpdateDTO.name());
        }
        if(bookUpdateDTO.autorship() != null){
            this.setAutorship(bookUpdateDTO.autorship());
        }
        if(bookUpdateDTO.description() != null){
            this.setDescription(bookUpdateDTO.description());
        }
    }



    public void updateBook(@Valid BookUpdtNoIdDTO bookUpdtNoIdDTO) {
        if(bookUpdtNoIdDTO.name() != null){
            this.setName(bookUpdtNoIdDTO.name());
        }
        if(bookUpdtNoIdDTO.autorship() != null){
            this.setAutorship(bookUpdtNoIdDTO.autorship());
        }
        if(bookUpdtNoIdDTO.description() != null){
            this.setDescription(bookUpdtNoIdDTO.description());
        }
    }
}
