package com.sun.finalwork.bean;

public class ChooseCourse {
    private int id;
    private String courseName;
    private String batchId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Override
    public String toString() {
        return "ChooseCourse{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", batchId='" + batchId + '\'' +
                '}';
    }
}
