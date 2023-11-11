package com.ppj.acl.adapter.jdbc.exception;

public class SqlReaderException extends RuntimeException {
    public SqlReaderException(String message) {
        super(message);
    }
    public SqlReaderException(Throwable cause) {
        super(cause);
    }
}
