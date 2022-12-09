package com.project.placa.mae.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

@Data
public class SignUpDTO {
    @Nullable
    private int age;
    @Nullable
    private String email;
    @Nullable
    private String username;
    @Nullable
    private String password;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFormat = LocalDate.now();
}
