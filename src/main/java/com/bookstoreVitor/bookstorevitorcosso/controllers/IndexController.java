package com.bookstoreVitor.bookstorevitorcosso.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class IndexController {
    
    @GetMapping
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
