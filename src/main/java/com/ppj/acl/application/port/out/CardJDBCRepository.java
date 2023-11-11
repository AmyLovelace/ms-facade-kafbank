package com.ppj.acl.application.port.out;

import com.ppj.acl.domain.Card;

public interface CardJDBCRepository {
    String CardCreate(Card card);

}
