package com.bookstoreVitor.bookstorevitorcosso.infra.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import com.bookstoreVitor.bookstorevitorcosso.services.dbService.DBService;

@Configuration
@Profile("test") // active perfil name  
public class TestConfig {

    @Autowired
    private DBService dbService;

    
    @Bean // ja vai subir
    public boolean dbInstance(){
        this.dbService.dataBaseInstance();
        return true;
    }

}
