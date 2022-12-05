package com.placa.mae.org.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDTO {
    @NotNull
    private String usernameOrEmail;
    @NotNull
    private String password;
}
