package com.incubator.project.entity;

import java.util.Objects;

public class Account {
    public static final String TABLE = "accounts";
    public static final String ID_COLUMN = "account_id";
    public static final String ACCOUNT_COLUMN = "account";
    public static final String USER_ID_COLUMN = "user_id";

    private Integer id;
    private int account;
    private Integer user_id;

    public Account(Integer id, int account, Integer user_id) {
        this.id = id;
        this.account = account;
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return account == account1.account &&
                id.equals(account1.id) &&
                user_id.equals(account1.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, user_id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account=" + account +
                ", user_id=" + user_id +
                '}';
    }
}
