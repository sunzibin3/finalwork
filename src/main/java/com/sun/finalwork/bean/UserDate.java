package com.sun.finalwork.bean;

public class UserDate {
    private String userNo;
    private Integer classNo;
    private String password;
    private String teacherRoomNo;
    private String userName;
    private String position;
    private String sex;
    private Integer userType;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherRoomNo() {
        return teacherRoomNo;
    }

    public void setTeacherRoomNo(String teacherRoomNo) {
        this.teacherRoomNo = teacherRoomNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserDate{" +
                "userNo='" + userNo + '\'' +
                ", classNo='" + classNo + '\'' +
                ", password='" + password + '\'' +
                ", teacherRoomNo='" + teacherRoomNo + '\'' +
                ", userName='" + userName + '\'' +
                ", position='" + position + '\'' +
                ", sex='" + sex + '\'' +
                ", userType=" + userType +
                '}';
    }
}
