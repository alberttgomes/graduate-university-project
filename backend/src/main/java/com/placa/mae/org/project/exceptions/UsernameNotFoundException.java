package com.placa.mae.org.project.exceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String message){
        super (message);
    }
}
