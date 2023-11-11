package com.ppj.acl.adapter.jdbc.postgres;

import com.ppj.acl.adapter.jdbc.postgres.model.AccountJDBCModel;
import com.ppj.acl.adapter.jdbc.dao.sql.GenericDAO;
import com.ppj.acl.adapter.jdbc.dao.sql.SqlReader;
import com.ppj.acl.adapter.rest.exception.BadRequestRestClientException;
import com.ppj.acl.application.port.out.AccountJDBCRepository;
import com.ppj.acl.config.ErrorCodeAccount;
import com.ppj.acl.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class AccountJDBCAdapter implements AccountJDBCRepository {
    private static final String SQL_GET_ACCOUNT = "sql/get-account.sql";
    private static final String SQL_INSERT_ACCOUNT = "sql/insert-account.sql";

    private static final String KEY_ACCOUNT_N = "accountnumber";
    private static final String KEY_AGE= "age";
 

     private final GenericDAO dao;

     private final String getAccount;
     private final String insertAccount;

    public AccountJDBCAdapter(final GenericDAO dao) {
        this.dao = dao;
        this.getAccount = SqlReader.read(SQL_GET_ACCOUNT);
        this.insertAccount = SqlReader.read(SQL_INSERT_ACCOUNT);
    }


    @Override
    public Integer createAccount(Account account) {
        log.info("Insertando una nueva cuenta a la BD [{}]", account);
        var params = new MapSqlParameterSource()
                .addValue(KEY_ACCOUNT_N, account.getAccountNumber())
                .addValue(KEY_AGE, account.getAge());
        return dao.insert(insertAccount,params,null).intValue();
    }

    @Override
    public Account getUserByName(String name) {
        var parameter = new MapSqlParameterSource().addValue(KEY_ACCOUNT_N, name);
            log.info("Se va a realziar la busqueda de la cuenta que tiene como usuario a: [{}]", name);
            var response =  dao.findOne(getAccount,parameter, AccountJDBCModel.class).orElseThrow(()-> new BadRequestRestClientException(ErrorCodeAccount.ACCOUNT_NOT_FOUND));
            return response.toDomain();
    }

}
