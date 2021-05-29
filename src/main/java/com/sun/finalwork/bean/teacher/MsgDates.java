package com.sun.finalwork.bean.teacher;

import com.sun.finalwork.bean.Student;

public class MsgDates {
    private Integer id;
    private String message;
    private String time;
    private String flag;
    private Student stuDate;

    @Override
    public String toString() {
        return "MsgDates{" +
                "message='" + message + '\'' +
                ", time='" + time + '\'' +
                ", flag='" + flag + '\'' +
                ", stuDate=" + stuDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Student getStuDate() {
        return stuDate;
    }

    public void setStuDate(Student stuDate) {
        this.stuDate = stuDate;
    }
}
