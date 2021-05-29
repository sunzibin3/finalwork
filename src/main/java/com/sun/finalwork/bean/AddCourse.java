package com.sun.finalwork.bean;

public class AddCourse {
    private String sno;
    private int courseId;
    private String sname;
    private String batch;
    private int quotaflag;

    public AddCourse(String sno, int courseId, String sname, String batch, int quotaflag) {
        this.sno = sno;
        this.courseId = courseId;
        this.sname = sname;
        this.batch = batch;
        this.quotaflag = quotaflag;
    }

    public int getQuotaflag() {
        return quotaflag;
    }

    public void setQuotaflag(int quotaflag) {
        this.quotaflag = quotaflag;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
