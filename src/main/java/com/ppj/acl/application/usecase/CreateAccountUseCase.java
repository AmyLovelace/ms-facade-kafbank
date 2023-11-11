package com.ppj.acl.application.usecase;



import com.ppj.acl.application.port.in.CreateAccount;
import com.ppj.acl.application.port.out.AccountJDBCRepository;
import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.config.exception.CustomHttpMessageNotReadableException;
import com.ppj.acl.domain.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreateAccountUseCase implements CreateAccount {

    private final AccountJDBCRepository accountJDBCRepository;


    /*@Override
    public Integer createAccount(Account card) {
        return kafkaProducerPort.sendMessage(card);
    }*/




    public void showAccount(Account account) {
        try {
            accountJDBCRepository.createAccount(account);
        } catch (CustomHttpMessageNotReadableException e) {
            log.error("Error al generar el mensaje: ", e);
            throw new CustomHttpMessageNotReadableException(ErrorCodeAccount.CARD_INVALID_REQUEST);
        }
    }


}
