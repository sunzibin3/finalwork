package com.sun.finalwork.bean;

public class EvaluateTeachers {
    private String teacherId;
    private String tname;
    private String img;
    private int quotaflag;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getQuotaflag() {
        return quotaflag;
    }

    public void setQuotaflag(int quotaflag) {
        this.quotaflag = quotaflag;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
