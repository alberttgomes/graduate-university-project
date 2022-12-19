package com.project.placa.mae.dto;

import java.time.LocalDateTime;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ArticleDTO {
    @Nullable
    private String title;
    @Nullable
    private String description;
    @Nullable
    private String body;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateArticle;    
}
