package com.noobz.iwant.entity;

public class SignRecordKey {
    private Integer accountId;

    private Integer meetingId;

    public SignRecordKey(Integer accountId, Integer meetingId) {
        this.accountId = accountId;
        this.meetingId = meetingId;
    }

    public SignRecordKey() {
        super();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }
}