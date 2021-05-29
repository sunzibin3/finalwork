package com.sun.finalwork.bean;

public class stuCourse {
    private int id;
    private String sno;
    private int courseId;
    private String sname;
    private String courseName;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "stuCourse{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", courseId=" + courseId +
                ", sname='" + sname + '\'' +
                ", courseName='" + courseName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
