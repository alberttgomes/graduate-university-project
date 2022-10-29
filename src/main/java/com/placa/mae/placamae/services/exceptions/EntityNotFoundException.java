package com.placa.mae.placamae.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message){
         super(message);
    }
}
