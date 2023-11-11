package com.ppj.acl.adapter.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppj.acl.application.port.in.CreateAccount;
import com.ppj.acl.application.port.out.CreateCard;
import com.ppj.acl.domain.Account;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumerAdapter implements KafkaConsumerPort {

    private final CreateAccount createAccount;
    private final CreateCard create;
    private final ObjectMapper objectMapper;

    public KafkaConsumerAdapter(CreateAccount createAccount, CreateCard create, ObjectMapper objectMapper) {
        this.createAccount = createAccount;
        this.create = create;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "account-topic", groupId = "myGroup3")
    public void getMessage(String json) {
        try {
            Account account = objectMapper.readValue(json, Account.class);

            createAccount.showAccount(account);

            create.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}