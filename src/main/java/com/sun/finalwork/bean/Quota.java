package com.sun.finalwork.bean;

public class Quota {
    private int id;
    private String quotaName;
    private String qutaValue;

    public Quota() {
    }

    public Quota(String quotaName, String qutaValue) {
        this.quotaName = quotaName;
        this.qutaValue = qutaValue;
    }

    public String getQutaValue() {
        return qutaValue;
    }

    public void setQutaValue(String qutaValue) {
        this.qutaValue = qutaValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName;
    }

    @Override
    public String toString() {
        return "Quota{" +
                "id=" + id +
                ", quotaName='" + quotaName + '\'' +
                ", qutaValue='" + qutaValue + '\'' +
                '}';
    }
}
