package com.noobz.iwant.entity;

public class User {
    private Integer accountId;

    private String realname;

    private String idno;

    private String volunteerNo;

    private String city;

    private String workPlace;

    private String job;

    private String jobLevel;

    private String education;

    private String special;

    private String email;

    private String mobile;

    private String address;

    private String skill;

    private String improve;

    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public User(Integer accountId, String realname, String idno, String volunteerNo, String city, String workPlace, String job, String jobLevel, String education, String special, String email, String mobile, String address, String skill, String improve) {
        this.accountId = accountId;
        this.realname = realname;
        this.idno = idno;
        this.volunteerNo = volunteerNo;
        this.city = city;
        this.workPlace = workPlace;
        this.job = job;
        this.jobLevel = jobLevel;
        this.education = education;
        this.special = special;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.skill = skill;
        this.improve = improve;
    }

    public User() {
        super();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getVolunteerNo() {
        return volunteerNo;
    }

    public void setVolunteerNo(String volunteerNo) {
        this.volunteerNo = volunteerNo == null ? null : volunteerNo.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel == null ? null : jobLevel.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special == null ? null : special.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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