package com.placa.mae.placamae.dto;

import com.placa.mae.placamae.domain.PeopleAdolescent;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PeopleAdolescentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long adolescentId;

    private int age;

    private LocalDate dateFormat = LocalDate.now();

    private String username;

    private String password;

    private String email;

    public PeopleAdolescentDTO (PeopleAdolescent adolescentReturnDataBase) {
        this.adolescentId = adolescentReturnDataBase.getAdolescentId();
        this.age = adolescentReturnDataBase.getAge();
        this.email = adolescentReturnDataBase.getEmail();
        this.password = adolescentReturnDataBase.getPassword();
        this.username = adolescentReturnDataBase.getUsername();
    }

}
