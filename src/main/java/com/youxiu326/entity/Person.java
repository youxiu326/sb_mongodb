package com.youxiu326.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 用户 一个用户多个账户
 */
@Document(collection="person")
@CompoundIndexes({
        @CompoundIndex(name = "age_idx", def = "{'lastName': 1, 'age': -1}")
})
public class Person {

    @Id
    private String id;

    @Indexed(unique = true)
    private Integer ssn;

    private String firstName;

    @Indexed
    private String lastName;

    private Integer age;

    @Transient
    private Integer accountTotal;

    @DBRef
    private List<Account> accounts;

    public Person(){}

    public Person(String id, Integer ssn, String firstName, String lastName, Integer age, Integer accountTotal, List<Account> accounts) {
        this.id = id;
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.accountTotal = accountTotal;
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(Integer accountTotal) {
        this.accountTotal = accountTotal;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}