package com.microsservice.cad.cadunico.exception;

public class BusinessException extends  RuntimeException{

    public BusinessException(String msg){
        super(msg);
    }
}
