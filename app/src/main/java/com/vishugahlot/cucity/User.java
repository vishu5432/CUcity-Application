package com.vishugahlot.cucity;

public class User {
    String course, name, email,surl;

    User(){

    }
    public User(String course, String name, String email, String surl) {
        this.course = course;
        this.name = name;
        this.email = email;
        this.surl = surl;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
