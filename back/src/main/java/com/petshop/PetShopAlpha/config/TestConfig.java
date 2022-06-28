package com.petshop.PetShopAlpha.config;

import com.petshop.PetShopAlpha.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaBaseDeDados() throws ParseException {
        this.dbService.instanciaBaseDeDados();
    }
}
