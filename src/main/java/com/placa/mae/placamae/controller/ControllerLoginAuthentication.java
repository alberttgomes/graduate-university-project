package com.placa.mae.placamae.controller;

import com.placa.mae.placamae.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("login/auth")
public class ControllerLoginAuthentication {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody @Validated LoginDTO loginDTO) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsernameOrEmail(), loginDTO.getPassword()
            ));
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
           
            return new ResponseEntity<>("User signed-in successfully.", HttpStatus.OK);

        } catch (Exception ex) {
            
            return ResponseEntity.badRequest().build();
       
        }

    }
}
