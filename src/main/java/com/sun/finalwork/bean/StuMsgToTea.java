package com.sun.finalwork.bean;

public class StuMsgToTea {
    private String sno;
    private String tno;
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "StuMsgToTea{" +
                "sno='" + sno + '\'' +
                ", tno='" + tno + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
