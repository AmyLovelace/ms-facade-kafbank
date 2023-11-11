package com.ppj.acl.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder

public class Account {

    String accountNumber;
    int age;















    @JsonCreator
    public Account(@JsonProperty("accountNumber") String accountNumber,
                   @JsonProperty("age") int age){
        this.accountNumber = accountNumber;
        this.age = age;


    }

}
