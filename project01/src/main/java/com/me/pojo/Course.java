package com.me.pojo;

public class Course {
    private String dsg_cname22;
    private Float dsg_ccredit22;

    @Override
    public String toString() {
        return "Course{" +
                "dsg_cname22='" + dsg_cname22 + '\'' +
                ", dsg_ccredit22=" + dsg_ccredit22 +
                '}';
    }

    public String getDsg_cname22() {
        return dsg_cname22;
    }

    public void setDsg_cname22(String dsg_cname22) {
        this.dsg_cname22 = dsg_cname22;
    }

    public Float getDsg_ccredit22() {
        return dsg_ccredit22;
    }

    public void setDsg_ccredit22(Float dsg_ccredit22) {
        this.dsg_ccredit22 = dsg_ccredit22;
    }

    public Course(String dsg_cname22, Float dsg_ccredit22) {
        this.dsg_cname22 = dsg_cname22;
        this.dsg_ccredit22 = dsg_ccredit22;
    }

    public Course() {
    }
}
