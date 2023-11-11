package com.ppj.acl.adapter.rest.exception;

import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.exception.GenericException;

public class NonTargetRestClientException extends GenericException {
    public NonTargetRestClientException(ErrorCodeAccount errorCodeAccount) {
        super(errorCodeAccount);
    }
}
