package com.ppj.acl.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Setter;
import lombok.Value;

@Value
@Builder
@Setter
public class Card {
    String cardNumber;
    String descriptionStatus;
    String membership;
    int balance;



    @JsonCreator
    public Card(@JsonProperty("cardNumber") String cardNumber,
                @JsonProperty("descriptionStatus") String descriptionStatus, @JsonProperty("membership") String membership , @JsonProperty("balance")int balance){
        this.cardNumber = cardNumber;
        this.descriptionStatus = descriptionStatus;
        this.membership = membership;
        this.balance = balance;
    }
}
