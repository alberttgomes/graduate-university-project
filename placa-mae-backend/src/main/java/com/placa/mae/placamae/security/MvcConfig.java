package com.placa.mae.placamae.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
    public void addViewController(@NotNull ViewControllerRegistry registry) {
        registry.addViewController("/adolescents").setViewName("adolescents");
        registry.addViewController("/adults").setViewName("adults");
        registry.addViewController("/kids").setViewName("kids");
    }
}
