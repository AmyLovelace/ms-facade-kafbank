package com.ppj.acl.application.port.out;

import com.ppj.acl.domain.Account;

public interface AccountRepository {
    Account getAccount(String name);
}
