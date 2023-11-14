package com.ppj.acl.adapter.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppj.acl.adapter.rest.model.card.CardBuilder;
import com.ppj.acl.application.port.in.CreateAccount;
import com.ppj.acl.application.port.out.CreateCard;
import com.ppj.acl.domain.Account;
import com.ppj.acl.domain.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerAdapter implements KafkaConsumerPort {

    private final CreateAccount createAccount;
    private final ObjectMapper objectMapper;



    public KafkaConsumerAdapter(CreateAccount createAccount, ObjectMapper objectMapper) {
        this.createAccount = createAccount;

        this.objectMapper = objectMapper;
    }


    @KafkaListener(topics = "account-topic-1", groupId = "myGroup")
    public void getMessage(String json) {
        try {
            log.info("llegó un mensaje!!!");
            Account account = objectMapper.readValue(json, Account.class);

            createAccount.showAccount(account);




            log.info("mandé a jdbc una tarjeta!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}