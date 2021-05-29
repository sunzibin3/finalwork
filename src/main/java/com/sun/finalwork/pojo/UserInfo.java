package com.sun.finalwork.pojo;

import java.util.Date;

public class UserInfo {
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * id
     */
    private Integer id;

    /**
     * 学生教师编号
     */
    private String userno;

    /**
     * 班级编号
     */
    private Integer classno;

    /**
     * password
     */
    private String password;

    /**
     * teacherroomno
     */
    private String teacherroomno;

    /**
     * username
     */
    private String username;

    /**
     * position
     */
    private String position;

    /**
     * sex
     */
    private Integer sex;

    /**
     * starttime
     */
    private String  starttime;

    /**
     * stoptime
     */
    private String stoptime;

    /**
     * usertype
     */
    private Integer usertype;

    /**
     * batchid
     */
    private String batchid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Integer getClassno() {
        return classno;
    }

    public void setClassno(Integer classno) {
        this.classno = classno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherroomno() {
        return teacherroomno;
    }

    public void setTeacherroomno(String teacherroomno) {
        this.teacherroomno = teacherroomno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getStoptime() {
        return stoptime;
    }

    public void setStoptime(String stoptime) {
        this.stoptime = stoptime;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userno='" + userno + '\'' +
                ", classno=" + classno +
                ", password='" + password + '\'' +
                ", teacherroomno='" + teacherroomno + '\'' +
                ", username='" + username + '\'' +
                ", position='" + position + '\'' +
                ", sex=" + sex +
                ", starttime=" + starttime +
                ", stoptime=" + stoptime +
                ", usertype=" + usertype +
                ", batchid='" + batchid + '\'' +
                '}';
    }
}
