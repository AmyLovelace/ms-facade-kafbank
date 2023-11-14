package com.ppj.acl.application.usecase;



import com.ppj.acl.application.port.in.CreateAccount;
import com.ppj.acl.application.port.out.AccountJDBCRepository;
import com.ppj.acl.application.port.out.CreateCard;
import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.exception.CustomHttpMessageNotReadableException;
import com.ppj.acl.domain.Account;
import com.ppj.acl.domain.Card;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreateAccountUseCase implements CreateAccount {

    private final AccountJDBCRepository accountJDBCRepository;
    private final CreateCard create;

    private static final String DEFAULT_STATUS = "Activo";

    private static final String DEFAULT_MEMBERSHIP = "Standard";

    private static final int DEFAULT_BALANCE = 0;


    /*@Override
    public Integer createAccount(Account card) {
        return kafkaProducerPort.sendMessage(card);
    }*/




    public void showAccount(Account account) {
        try {

            accountJDBCRepository.createAccount(account);
            create.create(
                    Card.builder()
                            .cardNumber(generateRandomCardNumber())
                            .descriptionStatus(DEFAULT_STATUS)
                            .membership(DEFAULT_MEMBERSHIP)
                            .balance(DEFAULT_BALANCE)
                            .build()
            );
        } catch (CustomHttpMessageNotReadableException e) {
            log.error("Error al generar el mensaje: ", e);
            throw new CustomHttpMessageNotReadableException(ErrorCodeAccount.CARD_INVALID_REQUEST);
        }
    }

    //arreglar creacion de card number

    private static String generateRandomCardNumber() {

        String cardNumber = String.valueOf(Math.random() * 10000000000000000L);


        return cardNumber.substring(0, 3) + "-" + cardNumber.substring(3, 6) + "-" + cardNumber.substring(6, 9) + "-" + cardNumber.substring(9);
    }


}
