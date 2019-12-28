package com.noobz.iwant.entity;

public class UserWithBLOBs extends User {
    private String skill;

    private String improve;

    public UserWithBLOBs(String accountId, String idno, String realname, String volunteerNo, String city, String workPlace, String job, String jobLevel, String education, String special, String email, String mobile, String address, String skill, String improve) {
        super(accountId, idno, realname, volunteerNo, city, workPlace, job, jobLevel, education, special, email, mobile, address);
        this.skill = skill;
        this.improve = improve;
    }

    public UserWithBLOBs() {
        super();
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getImprove() {
        return improve;
    }

    public void setImprove(String improve) {
        this.improve = improve == null ? null : improve.trim();
    }
}