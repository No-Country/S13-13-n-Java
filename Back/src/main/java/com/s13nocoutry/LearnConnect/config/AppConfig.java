package com.s13nocoutry.LearnConnect.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * Bean para mapear del modelo al DTO o del DTO al modelo
     *
     * @return modelMapper mapeador de informacion de una clase a otra
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
