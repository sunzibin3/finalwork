package com.sun.finalwork.pojo;

public class Quota {
    private Integer id;
    private String quotaName;
    private Integer weight;
    private Integer isUsed;

    @Override
    public String toString() {
        return "Quota{" +
                "id=" + id +
                ", quotaName='" + quotaName + '\'' +
                ", weight=" + weight +
                ", isUsed=" + isUsed +
                '}';
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
