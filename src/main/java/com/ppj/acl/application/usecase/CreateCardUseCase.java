package com.ppj.acl.application.usecase;

import com.ppj.acl.application.port.out.CardJDBCRepository;
import com.ppj.acl.application.port.out.CreateCard;
import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.exception.CustomHttpMessageNotReadableException;
import com.ppj.acl.domain.Card;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreateCardUseCase implements CreateCard {


    private final CardJDBCRepository cardJDBCRepository;

    @Override
    public void create(Card card) {
        //HACER LOGICA AGREGAR CAMPOS

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
