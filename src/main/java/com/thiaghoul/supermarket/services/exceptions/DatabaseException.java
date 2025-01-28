package com.thiaghoul.supermarket.services.exceptions;

import org.aspectj.bridge.Message;

public class DatabaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DatabaseException(String message){
        super(message);
    }

}
