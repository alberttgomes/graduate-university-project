package com.project.placa.mae.dto;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import lombok.Data;

@Data
public class LoginDTO {
    @Nullable
    private String usernameOrEmail;
    @Nullable
    private String password;
}
