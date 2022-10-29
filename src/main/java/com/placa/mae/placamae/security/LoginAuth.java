package com.placa.mae.placamae.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

public class LoginAuth {
    @NotBlank
    private String password;
    @NotBlank
    private String username;
    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(password, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
