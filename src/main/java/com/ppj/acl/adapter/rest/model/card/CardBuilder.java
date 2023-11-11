package com.ppj.acl.adapter.rest.model.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ppj.acl.domain.Card;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CardBuilder {

    private static final String DEFAULT_STATUS = "Activo";

    private static final String DEFAULT_MEMBERSHIP = "Standard";

    private static final int DEFAULT_BALANCE = 0;


    private String cardNumber;

    private String descriptionStatus = DEFAULT_STATUS;

    private String membership = DEFAULT_MEMBERSHIP;

    private int balance = DEFAULT_BALANCE;


    public Card toDomain() {
        return Card.builder()
                .cardNumber(generateRandomCardNumber())
                .descriptionStatus(descriptionStatus)
                .membership(membership)
                .balance(balance)
                .build();
    }

    private String generateRandomCardNumber() {

        String cardNumber = String.valueOf(Math.random() * 10000000000000000L);


        return cardNumber.substring(0, 3) + "-" + cardNumber.substring(3, 6) + "-" + cardNumber.substring(6, 9) + "-" + cardNumber.substring(9);
    }


}
