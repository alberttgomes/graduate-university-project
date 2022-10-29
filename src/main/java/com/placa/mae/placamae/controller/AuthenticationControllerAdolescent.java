package com.placa.mae.placamae.controller;

import com.placa.mae.placamae.dto.TokenDTO;
import com.placa.mae.placamae.security.LoginAuth;
import com.placa.mae.placamae.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("adolescent/auth")
public class AuthenticationControllerAdolescent {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> authenticate (@RequestBody @Validated LoginAuth login) {
        UsernamePasswordAuthenticationToken dataLogin = login.convert();

        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.generateToken(authentication);

            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));

        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
