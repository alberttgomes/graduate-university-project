package com.placa.mae.placamae.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginDTO {
    @NotNull
    private String usernameOrEmail;
    @NotNull
    private String password;
}
