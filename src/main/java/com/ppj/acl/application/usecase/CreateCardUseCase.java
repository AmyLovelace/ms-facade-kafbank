package com.ppj.acl.application.usecase;

import com.ppj.acl.adapter.rest.model.card.CardBuilder;
import com.ppj.acl.application.port.out.CardJDBCRepository;
import com.ppj.acl.application.port.out.CreateCard;
import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.exception.CustomHttpMessageNotReadableException;
import com.ppj.acl.domain.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateCardUseCase implements CreateCard {

    private final CardBuilder cardBuilder;
    private final CardJDBCRepository cardJDBCRepository;

    public CreateCardUseCase(CardBuilder cardBuilder, CardJDBCRepository cardJDBCRepository) {
        this.cardBuilder = cardBuilder;
        this.cardJDBCRepository = cardJDBCRepository;
    }

    @Override
    public void create() {
        try {
            cardJDBCRepository.CardCreate(cardBuilder.toDomain());
        } catch (CustomHttpMessageNotReadableException e) {
            log.error("Error al generar el mensaje en CreateCardUseCase: ", e);
            throw new CustomHttpMessageNotReadableException(ErrorCodeAccount.INVALID_CARD_MESSAGE_REQUEST);
        }


    }
}
