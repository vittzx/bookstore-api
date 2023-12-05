package com.bookstoreVitor.bookstorevitorcosso.infra.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bookstoreVitor.bookstorevitorcosso.services.dbService.DBService;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;



    @Bean
    public boolean instanceDataBase(){
        if(strategy.equals("create")){
            this.dbService.dataBaseInstance();
            return true;
        }
        return false;
    }
}