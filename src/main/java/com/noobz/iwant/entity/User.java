package com.noobz.iwant.entity;

public class User extends UserKey {

    private String realname;

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

    public User(String accountId, String idno, String realname, String volunteerNo, String city, String workPlace, String job, String jobLevel, String education, String special, String email, String mobile, String address) {
        super(accountId, idno);
        this.realname = realname;
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
    }

    public User() {
        super();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
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
}