package com.sun.finalwork.bean.teacher;

import org.springframework.web.multipart.MultipartFile;

public class TeaChangeMsg {
    private MultipartFile fileName;
    private String password;
    private String userName;
    private Integer sex;
    private String userNo;


    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Override
    public String toString() {
        return "TeaChangeMsg{" +
                "password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                '}';
    }

    public MultipartFile getFileName() {
        return fileName;
    }

    public void setFileName(MultipartFile fileName) {
        this.fileName = fileName;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
