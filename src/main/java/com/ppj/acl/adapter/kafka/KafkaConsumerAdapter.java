package com.ppj.acl.adapter.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppj.acl.application.port.in.CreateAccount;
import com.ppj.acl.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerAdapter implements KafkaConsumerPort {

    private final CreateAccount createAccount;
    private final ObjectMapper objectMapper;

    public KafkaConsumerAdapter(CreateAccount createAccount, ObjectMapper objectMapper) {
        this.createAccount = createAccount;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "account-topic", groupId = "myGroup3")
    public void getMessage(String json) {
        try {

            Account account = objectMapper.readValue(json, Account.class);

            Account accountCreate = new Account(account.getAccountNumber(), account.getAge());



            createAccount.showAccount(accountCreate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

