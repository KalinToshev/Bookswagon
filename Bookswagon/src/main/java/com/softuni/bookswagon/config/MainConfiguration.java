package com.softuni.bookswagon.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {
    // Create a bean for the ModelMapper instance
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
