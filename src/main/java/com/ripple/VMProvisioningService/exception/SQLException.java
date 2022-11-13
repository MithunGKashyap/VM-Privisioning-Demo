package com.ripple.VMProvisioningService.exception;

public class SQLException extends RuntimeException{
    public SQLException(String msg){
        super("SQL Error: "+ msg);
    }
}
