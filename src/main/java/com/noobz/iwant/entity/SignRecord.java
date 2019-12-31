package com.noobz.iwant.entity;

import java.util.Date;

public class SignRecord extends SignRecordKey {
    private Date createTime;

    public SignRecord(Integer accountId, Integer meetingId, Date createTime) {
        super(accountId, meetingId);
        this.createTime = createTime;
    }

    public SignRecord() {
        super();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}