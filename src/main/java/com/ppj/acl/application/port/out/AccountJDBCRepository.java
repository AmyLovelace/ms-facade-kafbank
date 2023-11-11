package com.ppj.acl.application.port.out;

import com.ppj.acl.domain.Account;

public interface AccountJDBCRepository {
    Integer createAccount(Account account);
    Account getUserByName(String name);
}
