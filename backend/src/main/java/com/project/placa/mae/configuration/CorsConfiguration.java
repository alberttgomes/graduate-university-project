package com.project.placa.mae.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/adolescents").allowedOrigins("http://localhost:3000").allowedMethods(
                "GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"
        );
        registry.addMapping("/adults").allowedOrigins("http://localhost:3000").allowedMethods(
                "GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"
        );
        registry.addMapping("/kids").allowedOrigins("http://localhost:3000").allowedMethods(
                "GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"
        );
        registry.addMapping("/teachers").allowedOrigins("http://localhost:3000").allowedMethods(
                "GET", "POST", "PUT", "OPTIONS", "HEAD", "TRACE", "CONNECT"
        );
    }
}
