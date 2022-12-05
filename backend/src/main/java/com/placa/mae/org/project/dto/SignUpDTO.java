package com.placa.mae.org.project.dto;

import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpDTO {
    @NotNull
    private int age;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFormat = LocalDate.now();
}
