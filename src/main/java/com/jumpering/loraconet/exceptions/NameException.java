package com.jumpering.loraconet.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class NameException extends Exception{

    public NameException(String msg){
        super(msg);
    }
}
