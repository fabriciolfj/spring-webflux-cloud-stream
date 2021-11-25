package com.github.fabrliciolfj.customerservice.exceptions;

public class CustomerSaveException extends RuntimeException {

    public CustomerSaveException(final String msg){
        super(msg);
    }
}
