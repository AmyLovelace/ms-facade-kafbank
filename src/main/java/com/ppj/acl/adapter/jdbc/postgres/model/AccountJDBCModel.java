package com.ppj.acl.adapter.jdbc.postgres.model;

import com.ppj.acl.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountJDBCModel implements Serializable {
    private String name;
    private int age;

    public Account toDomain() {
        return Account.builder().accountNumber(this.name).age(this.age).build();
    }
}
