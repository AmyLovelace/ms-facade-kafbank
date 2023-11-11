package com.ppj.acl.adapter.controller.model.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ppj.acl.domain.Account;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CardRest {
    String accountNumber;
    int age;
    int cardNumber;
    String membership;
    int cardStatus;
    String descriptionStatus;






    public static  CardRest toCardRest(Account account){
        return Objects.nonNull(account) ?
                CardRest.builder()
                        .accountNumber(account.getAccountNumber())
                        .age(account.getAge())
                        .build() : null;
    }

    public Account toDomain(){
        return Account.builder()
                .accountNumber(this.accountNumber)
                .age(this.age)
                /*.cardNumber(this.cardNumber)
                .membership(this.membership)
                .cardStatus(this.cardStatus)
                .descriptionStatus(this.descriptionStatus)*/
                .build();

    }
}
