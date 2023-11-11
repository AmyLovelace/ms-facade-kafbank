package com.ppj.acl.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeAccount {
    INTERNAL_ERROR(100, "Error interno del servidor"),
    CARD_INVALID_REQUEST(102,  "datos invalidos o con formato no aplicable "),
    WEB_CLIENT_GENERIC(101, "Error del Web client"),
    ACCOUNT_NOT_FOUND(102, "No se encontro la cuenta"),
    ACCOUNT_BAD_REQUEST(103, "El llamado a la cuenta retorno una peticion invalida"),
    ACCOUNT_TIMEOUT(104, "El llamado a la cuenta devolvio error"),
    MEMBERSHIP_NOT_FOUND(105, "No se encontro la afiliacion"),
    MEMBERSHIP_BAD_REQUEST(106, "El llamado a la afiliacion retorno una peticion invalida"),
    MEMBERSHIP_TIMEOUT(107, "El llamado a la afiliacion devolvio error");


    private final int value;
    private final String reason;
}
