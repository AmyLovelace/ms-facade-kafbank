package com.ppj.acl.application.usecase;

import com.ppj.acl.adapter.rest.model.card.CardBuilder;
import com.ppj.acl.application.port.out.CardJDBCRepository;
import com.ppj.acl.application.port.out.CreateCard;
import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.exception.CustomHttpMessageNotReadableException;
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
        try{
            cardBuilder.getCardNumber();
            cardBuilder.getDescriptionStatus();
            cardBuilder.getMembership();
            cardBuilder.getBalance();


            cardJDBCRepository.CardCreate(card);
        }catch(CustomHttpMessageNotReadableException e){
            log.error("Error al generar el mensaje en CreateCardUseCase: ", e);
            throw new CustomHttpMessageNotReadableException(ErrorCodeAccount.INVALID_CARD_MESSAGE_REQUEST);
        }

    }



    /*@Override
    public Card CardCreate(Card card) {
        try {
            Card create = new Card(card.)
            accountJDBCRepository.createAccount(account);
        } catch (CustomHttpMessageNotReadableException e) {
            log.error("Error al generar el mensaje: ", e);
            throw new CustomHttpMessageNotReadableException(ErrorCodeAccount.CARD_INVALID_REQUEST);
        }*/
}
