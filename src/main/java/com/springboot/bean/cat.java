package com.springboot.bean;

public class cat {
    private Integer cId;
    private String cName;
    private Integer cAge;

    @Override
    public String toString() {
        return "cat{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cAge=" + cAge +
                '}';
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcAge() {
        return cAge;
    }

    public void setcAge(Integer cAge) {
        this.cAge = cAge;
    }
}
