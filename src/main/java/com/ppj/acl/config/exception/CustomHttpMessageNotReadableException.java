package com.ppj.acl.config.exception;

import com.ppj.acl.config.ErrorCodeAccount;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class CustomHttpMessageNotReadableException extends HttpMessageNotReadableException {

    public CustomHttpMessageNotReadableException(ErrorCodeAccount errorCode){
        super(String.valueOf(errorCode.getValue()));}
}
