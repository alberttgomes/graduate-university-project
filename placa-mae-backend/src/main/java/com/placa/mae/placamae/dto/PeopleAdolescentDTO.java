package com.placa.mae.placamae.dto;

import com.placa.mae.placamae.domain.PeopleAdolescent;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PeopleAdolescentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long adolescentId;
    private int age;
    private String username;
    private String password;
    private LocalDateTime dateRegister;
    private String email;

    public PeopleAdolescentDTO (PeopleAdolescent adolescentReturnDataBase) {
        this.adolescentId = adolescentReturnDataBase.getAdolescentId();
        this.age = adolescentReturnDataBase.getAge();
        this.dateRegister = adolescentReturnDataBase.getDateRegister();
        this.email = adolescentReturnDataBase.getEmail();
        this.password = adolescentReturnDataBase.getPassword();
        this.username = adolescentReturnDataBase.getPassword();
    }

}
