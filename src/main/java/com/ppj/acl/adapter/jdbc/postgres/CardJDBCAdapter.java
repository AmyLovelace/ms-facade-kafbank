package com.ppj.acl.adapter.jdbc.postgres;

import com.ppj.acl.adapter.jdbc.dao.sql.GenericDAO;
import com.ppj.acl.application.port.out.CardJDBCRepository;
import com.ppj.acl.domain.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardJDBCAdapter implements CardJDBCRepository {

    private static final String SQL_CREATE_CARD = "sql/create-card";

    private static final String SQL_INSERT_ACCOUNT = "sql/insert-card.sql";

    private static final String KEY_CARD_NUM = "cardnumber";
    private static final String KEY_MEMBERSHIP = "membership";
    private static final String KEY_CARD_STATUS = "cardstatus";
    private static final String KEY_DESCRIPTION = "descriptionstatus";

    private static final String KEY_BALANCE = "balance";

    private final GenericDAO dao;

    private final String createCard;
    private final String insertCard;

    public CardJDBCAdapter(GenericDAO dao, String createCard, String insertCard) {
        this.dao = dao;
        this.createCard = createCard;
        this.insertCard = insertCard;
    }

    @Override
    public String CardCreate(Card card) {
        return null;
    }
}
