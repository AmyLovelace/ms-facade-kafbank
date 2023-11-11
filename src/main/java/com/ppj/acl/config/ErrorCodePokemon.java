package com.ppj.acl.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodePokemon {
    INTERNAL_ERROR(100, "Error interno del servidor"),
    WEB_CLIENT_GENERIC(101, "Error del Web client"),
    POKEMON_NOT_FOUND(102, "No se encontro el pokemon"),
    POKEMON_BAD_REQUEST(103, "El llamado a pokemon retorno una peticion invalida"),
    POKEMON_TIMEOUT(104, "El llamado a pokemon devolvio error"),
    ABILITY_NOT_FOUND(105, "No se encontro la habilidad"),
    ABILITY_BAD_REQUEST(106, "El llamado a la habilidad retorno una peticion invalida"),
    ABILITY_TIMEOUT(107, "El llamado a la habilidad devolvio error"),
    TYPE_NOT_FOUND(108, "No se encontro el type"),
    TYPE_BAD_REQUEST(109, "El llamado al type retorno una peticion invalida"),
    TYPE_TIMEOUT(110, "El llamado al type devolvio error");

    private final int value;
    private final String reason;

 }
