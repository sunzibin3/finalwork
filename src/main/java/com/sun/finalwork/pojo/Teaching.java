package com.sun.finalwork.pojo;

public class Teaching {

    /**
     * id
     */
    private Integer id;

    /**
     * 外键班级id
     */
    private Integer classId;

    /**
     * 外键课程id
     */
    private Integer courseId;

    /**
     * 外键教师id来自user
     */
    private Integer teacherId;

    /**
     * batchid
     */
    private Integer batchId;


    @Override
    public String toString() {
        return "Teaching{" +
                "id=" + id +
                ", classId=" + classId +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", batchId=" + batchId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }
}
