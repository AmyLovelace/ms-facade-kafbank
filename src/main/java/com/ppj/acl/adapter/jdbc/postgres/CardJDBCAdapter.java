package com.ppj.acl.adapter.jdbc.postgres;

import com.ppj.acl.application.port.out.CardJDBCRepository;
import com.ppj.acl.domain.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardJDBCAdapter implements CardJDBCRepository {

    private static final String SQL_CREATE_CARD = "sql/create-card";

    private static final String SQL_INSERT_ACCOUNT = "sql/insert-card.sql";



    @Override
    public String CardCreate(Card card) {
        return null;
    }
}
