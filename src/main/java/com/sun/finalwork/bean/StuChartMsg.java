package com.sun.finalwork.bean;

public class StuChartMsg {
    private String name;
    private String value;

    @Override
    public String toString() {
        return "StuChartMsg{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
