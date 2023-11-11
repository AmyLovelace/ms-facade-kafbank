package com.ppj.acl.adapter.rest.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ppj.acl.domain.Account;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountModel {
    private String accountNumber;
    private int age;


    public Account toAccountDomain(){
        return Account.builder()
                .accountNumber(this.accountNumber)
                .age(this.age)
                .build();

    }
}
