package com.bookstoreVitor.bookstorevitorcosso.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstoreVitor.bookstorevitorcosso.services.DBService;

@Configuration
@Profile("test") // active perfil name  
public class TestConfig {

    @Autowired
    private DBService dbService;

    @PostMapping
    @Bean // ja vai subir
    public boolean dbInstance(){
        this.dbService.dataBaseInstance();
        return true;
    }

}
