package com.placa.mae.placamae.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerPlacaMaeConfig {
    String title = "Placa Mae API";
    String description = "This API is a Project to placamae.org";
    String version = "1.0";
    String terms = "Terms of Service";
    String email = "";
    String license = "";
    String licenseUrl = "";


    @Bean
    public Docket api() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.placa.mae.placamae"))
                .paths(PathSelectors.ant("adolescents/**"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
//        ApiInfo info = new ApiInfo(title, description, version, terms, new Contact("", "", email),
//                license,
//                licenseUrl,
//                new ArrayList<VendorExtension>());
          return null;
    }
}
