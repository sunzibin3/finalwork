package com.sun.finalwork.bean;

public class Student {
    private String userNo;
    private String password;
    private String userName;
    private String sex;
    private String position;
    private String classNo;
    private String className;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userNo='" + userNo + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", classNo='" + classNo + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
