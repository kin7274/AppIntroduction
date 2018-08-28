package com.example.administrator.appintroduction;

public class CardItem {
    // 4개 + 이미지 후에
    private String name;
    private String grade;
    private String email;
    private String call;

    public CardItem(String name, String grade, String email, String call) {
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.call = call;
    }

    public String getName(){
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public String getCall() {
        return call;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCall(String call) {
        this.call = call;
    }
}