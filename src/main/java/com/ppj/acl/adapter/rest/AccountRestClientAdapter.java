package com.ppj.acl.adapter.rest;

import com.ppj.acl.adapter.rest.model.account.AccountModel;
import com.ppj.acl.adapter.rest.exception.EmptyOrNullBodyRestClientException;
import com.ppj.acl.application.port.out.AccountRepository;
import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.property.AccountProperty;
import com.ppj.acl.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Repository
public class AccountRestClientAdapter implements AccountRepository {

    private final AccountProperty property;
    private final RestTemplate restTemplate;

    public AccountRestClientAdapter(AccountProperty property, RestTemplate restTemplate) {
        this.property = property;
        this.restTemplate = restTemplate;
    }

    @Override
    public Account getAccount(String name) {
        log.info("Servicio obtener pokemon, buscar [{}]" , property.getURL(property.getUrlName(),name));
        log.debug("Este mensaje no debe aparecer en el modo develop");
        AccountModel response = Optional.ofNullable(restTemplate.getForObject(property.getURL(property.getUrlName(),name),AccountModel.class,name))
                .orElseThrow(() -> new EmptyOrNullBodyRestClientException(ErrorCodeAccount.ACCOUNT_NOT_FOUND));
        log.info("Respuesta obtenida desde el servicio para obtener account data : [{}]", response);
        return response.toAccountDomain();

    }
}
