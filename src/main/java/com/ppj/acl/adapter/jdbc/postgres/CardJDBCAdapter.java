package com.ppj.acl.adapter.jdbc.postgres;

import com.ppj.acl.adapter.jdbc.dao.sql.GenericDAO;
import com.ppj.acl.adapter.jdbc.dao.sql.SqlReader;
import com.ppj.acl.application.port.out.CardJDBCRepository;
import com.ppj.acl.domain.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardJDBCAdapter implements CardJDBCRepository {

    private static final String SQL_CREATE_CARD = "sql/create-card.sql";

    private static final String SQL_INSERT_ACCOUNT = "sql/insert-card.sql";

    private static final String KEY_CARD_NUM = "cardnumber";
    private static final String KEY_MEMBERSHIP = "membership";
    private static final String KEY_DESCRIPTION = "descriptionstatus";

    private static final String KEY_BALANCE = "balance";

    private final GenericDAO dao;

    private final String createCard;
    private final String insertCard;

    public CardJDBCAdapter(final GenericDAO dao) {

        this.dao = dao;
        this.createCard = SqlReader.read(SQL_CREATE_CARD);

        this.insertCard = SqlReader.read(SQL_INSERT_ACCOUNT);

    }

    @Override
    public Integer cardCreate(Card card) {
        log.info("Insertando una nueva tarjeta a la BD [{}]", card);

        var params = new MapSqlParameterSource();
        params.addValue("cardnumber", card.getCardNumber());
        params.addValue("descriptionstatus", card.getDescriptionStatus());
        params.addValue("membership", card.getMembership());
        params.addValue("balance", card.getBalance());

        return dao.update(createCard, params);
    }

}
