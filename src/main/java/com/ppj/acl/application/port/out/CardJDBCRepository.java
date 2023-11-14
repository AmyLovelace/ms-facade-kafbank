package com.ppj.acl.application.port.out;

import com.ppj.acl.adapter.rest.model.card.CardBuilder;
import com.ppj.acl.domain.Card;

public interface CardJDBCRepository {
    Integer cardCreate(Card card);

}
