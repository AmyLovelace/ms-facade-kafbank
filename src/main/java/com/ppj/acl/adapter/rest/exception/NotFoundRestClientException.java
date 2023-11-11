package com.ppj.acl.adapter.rest.exception;

import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.ErrorCodePokemon;
import com.ppj.acl.config.exception.GenericException;

public class NotFoundRestClientException extends GenericException {
    public NotFoundRestClientException(ErrorCodeAccount errorCodeAccount) {
        super(errorCodeAccount);
    }
}
