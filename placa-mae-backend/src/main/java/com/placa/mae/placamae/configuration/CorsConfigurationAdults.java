package com.placa.mae.placamae.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
public class CorsConfigurationAdults implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry adults) {
        adults.addMapping("/adults").allowedOrigins("http://localhost:19006").allowedMethods(
            "GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"
        );
    }
    
}