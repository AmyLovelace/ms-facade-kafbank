package com.ppj.acl.config.exception;


import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.ErrorCodePokemon;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;

public abstract class GenericException extends RuntimeException {
    private static final String SPACE = StringUtils.SPACE;
    private static final String COMMA = ",";
    private final ErrorCodeAccount errorCodeAccount;

    protected GenericException( ErrorCodeAccount errorCodeAccount) {
        super(errorCodeAccount.getReason());
        this.errorCodeAccount = errorCodeAccount;

    }

    protected GenericException(ErrorCodeAccount errorCodeAccount, String message) {
        super(buildMessage(message, errorCodeAccount));
        this.errorCodeAccount = errorCodeAccount;
    }

    protected GenericException(ErrorCodeAccount errorCodeAccount, String message, Throwable cause) {
        super(buildMessage(message, errorCodeAccount), cause);
        this.errorCodeAccount = errorCodeAccount;

    }

    public ErrorCodeAccount getCode() {
        return this.errorCodeAccount;
    }

    private static String buildMessage(String message, ErrorCodeAccount errorCodeAccount) {
        return String.format("%s%s%s%s", errorCodeAccount.getReason(), COMMA, SPACE, message);
    }
}
