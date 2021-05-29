package com.sun.finalwork.bean.teacher;

public class TeaEvaData {
    private String tno;
    private String eavtno;
    private String id;
    private String value;

    @Override
    public String toString() {
        return "TeaEvaData{" +
                "tno='" + tno + '\'' +
                ", eavtno='" + eavtno + '\'' +
                ", id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getEavtno() {
        return eavtno;
    }

    public void setEavtno(String eavtno) {
        this.eavtno = eavtno;
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
