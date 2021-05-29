package com.sun.finalwork.bean;

/**
 * 学生评价表
 */
public class StuEva {
    private String sno;
    private String tno;
    private String id;
    private String value;

    @Override
    public String toString() {
        return "stuEva{" +
                "sno='" + sno + '\'' +
                ", tno='" + tno + '\'' +
                ", id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
