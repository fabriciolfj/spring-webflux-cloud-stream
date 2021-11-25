package com.github.fabrliciolfj.customerservice.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final String msg){
        super(msg);
    }
}
