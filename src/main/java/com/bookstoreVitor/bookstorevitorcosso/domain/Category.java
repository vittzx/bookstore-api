package com.bookstoreVitor.bookstorevitorcosso.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Book> books;

    public Category(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        this.books = new ArrayList<>();
    }


}
