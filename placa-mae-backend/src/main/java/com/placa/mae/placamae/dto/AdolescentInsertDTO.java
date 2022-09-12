package com.placa.mae.placamae.dto;

import com.placa.mae.placamae.domain.MaterialAdolescent;
import com.placa.mae.placamae.domain.PeopleAdolescent;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdolescentInsertDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    @NotBlank(message = "field mandatory")
    @Email(message = "format incorrect email")
    private String email;
    @NotBlank(message = "field mandatory")
    private String password;
    @NotBlank(message = "field mandatory")
    private String username;
    private List<MaterialAdolescent> materialAdolescents = new ArrayList<>();
    private LocalDateTime dateRegister = LocalDateTime.now();

    public AdolescentInsertDTO(PeopleAdolescent adolescentReturnDataBase) {
            this.email = adolescentReturnDataBase.getEmail();
            this.dateRegister = adolescentReturnDataBase.getDateRegister();
            this.password = adolescentReturnDataBase.getPassword();
            this.username = adolescentReturnDataBase.getUsername();
            this.materialAdolescents = adolescentReturnDataBase.getAdolescentMaterial();
    }

}
