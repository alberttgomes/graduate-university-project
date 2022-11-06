package com.placa.mae.placamae.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Setter
@Getter
public class AdolescentInsertDTO implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFormat = LocalDate.now();

    @NotNull(message = "The field is mandatory")
    private int age;

    @Email(message = "This field have format email.")
    @NotNull(message = "The field is mandatory")
    private String email;

    @NotNull(message = "The field is mandatory")
    private String password;

    @NotNull(message = "The field is mandatory")
    private String username;

}