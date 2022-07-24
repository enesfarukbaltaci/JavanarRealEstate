package com.javanar.realestate.exception.message;

import org.springframework.data.crossstore.ChangeSetPersister;

public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(String message){
        super(message);
    }
}
