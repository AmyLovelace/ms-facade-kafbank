package com.ppj.acl.adapter.rest.model.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ppj.acl.domain.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@Builder
public class CardBuilder {

    private static final String DEFAULT_STATUS = "Activo";

    private static final String DEFAULT_MEMBERSHIP = "Standard";

    private static final int DEFAULT_BALANCE = 0;

    @JsonProperty("cardnumber")
    @Builder.Default
    private String cardNumber = generateRandomCardNumber();

    @JsonProperty("descriptionstatus")
    @Builder.Default
    private String descriptionStatus = DEFAULT_STATUS;

    @JsonProperty("membership")
    @Builder.Default
    private String membership = DEFAULT_MEMBERSHIP;

    @JsonProperty("balance")
    @Builder.Default
    private int balance = DEFAULT_BALANCE;

    public CardBuilder() {

    }


    public CardBuilder cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CardBuilder descriptionStatus(String descriptionStatus) {
        this.descriptionStatus = descriptionStatus;
        return this;
    }

    public CardBuilder membership(String membership) {
        this.membership = membership;
        return this;
    }

    public CardBuilder balance(int balance) {
        this.balance = balance;
        return this;
    }


    private static String generateRandomCardNumber() {

        String cardNumber = String.valueOf(Math.random() * 10000000000000000L);


        return cardNumber.substring(0, 3) + "-" + cardNumber.substring(3, 6) + "-" + cardNumber.substring(6, 9) + "-" + cardNumber.substring(9);
    }


}
