package com.noobz.iwant.entity;

import java.util.Date;

public class Meeting {
    private Integer meetingId;

    private String title;

    private String content;

    private String position;

    private String lecturer;

    private Integer personLimit;

    private Date createTime;

    private Date endTime;

    public Meeting(Integer meetingId, String title, String content, String position, String lecturer, Integer personLimit, Date createTime, Date endTime) {
        this.meetingId = meetingId;
        this.title = title;
        this.content = content;
        this.position = position;
        this.lecturer = lecturer;
        this.personLimit = personLimit;
        this.createTime = createTime;
        this.endTime = endTime;
    }

    public Meeting() {
        super();
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer == null ? null : lecturer.trim();
    }

    public Integer getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(Integer personLimit) {
        this.personLimit = personLimit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}