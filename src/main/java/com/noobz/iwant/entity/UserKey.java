package com.noobz.iwant.entity;

public class UserKey {
    private String accountId;

    private String idno;

    public UserKey(String accountId, String idno) {
        this.accountId = accountId;
        this.idno = idno;
    }

    public UserKey() {
        super();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }
}