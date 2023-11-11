package com.ppj.acl.adapter.jdbc.postgres;

import com.ppj.acl.adapter.jdbc.dao.sql.GenericDAO;
import com.ppj.acl.adapter.rest.model.card.CardBuilder;
import com.ppj.acl.application.port.out.CardJDBCRepository;
import com.ppj.acl.domain.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardJDBCAdapter implements CardJDBCRepository {

    private static final String SQL_CREATE_CARD = "sql/create-card";

    private static final String SQL_INSERT_ACCOUNT = "sql/insert-card.sql";

    private static final String KEY_CARD_NUM = "cardnumber";
    private static final String KEY_MEMBERSHIP = "membership";
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
    public Integer CardCreate(Card card) {
        log.info("Insertando una nueva tarjeta a la BD [{}]", card);
        var params = new MapSqlParameterSource()
                .addValue(KEY_CARD_NUM, card.getCardNumber())
                .addValue(KEY_DESCRIPTION,card.getDescriptionStatus())
                .addValue(KEY_MEMBERSHIP,card.getMembership())
                .addValue(KEY_BALANCE, card.getBalance());
        
        log.info("Exito al insertar una nueva tarjeta a la BD [{}]", card);

        return dao.insert(createCard,params,null).intValue();



    }
}
