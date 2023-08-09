package com.me.pojo;

public class Student {
    private  String dsg_sno22;
    private  String dsg_sname22;
    private  String dsg_ssex22;
    private Integer dsg_sage22;

    private String dsg_aname22;
    private  String dsg_ssum22;
    private  String dsg_clname22;

    @Override
    public String toString() {
        return "Student{" +
                "dsg_sno22='" + dsg_sno22 + '\'' +
                ", dsg_sname22='" + dsg_sname22 + '\'' +
                ", dsg_ssex22='" + dsg_ssex22 + '\'' +
                ", dsg_sage22=" + dsg_sage22 +
                ", dsg_aname22='" + dsg_aname22 + '\'' +
                ", dsg_ssum22='" + dsg_ssum22 + '\'' +
                ", dsg_clname22='" + dsg_clname22 + '\'' +
                '}';
    }

    public String getDsg_sno22() {
        return dsg_sno22;
    }

    public void setDsg_sno22(String dsg_sno22) {
        this.dsg_sno22 = dsg_sno22;
    }

    public String getDsg_sname22() {
        return dsg_sname22;
    }

    public void setDsg_sname22(String dsg_sname22) {
        this.dsg_sname22 = dsg_sname22;
    }

    public String getDsg_ssex22() {
        return dsg_ssex22;
    }

    public void setDsg_ssex22(String dsg_ssex22) {
        this.dsg_ssex22 = dsg_ssex22;
    }

    public Integer getDsg_sage22() {
        return dsg_sage22;
    }

    public void setDsg_sage22(Integer dsg_sage22) {
        this.dsg_sage22 = dsg_sage22;
    }

    public String getDsg_aname22() {
        return dsg_aname22;
    }

    public void setDsg_aname22(String dsg_aname22) {
        this.dsg_aname22 = dsg_aname22;
    }

    public String getDsg_ssum22() {
        return dsg_ssum22;
    }

    public void setDsg_ssum22(String dsg_ssum22) {
        this.dsg_ssum22 = dsg_ssum22;
    }

    public String getDsg_clname22() {
        return dsg_clname22;
    }

    public void setDsg_clname22(String dsg_clname22) {
        this.dsg_clname22 = dsg_clname22;
    }

    public Student(String dsg_sno22, String dsg_sname22, String dsg_ssex22, Integer dsg_sage22, String dsg_aname22, String dsg_ssum22, String dsg_clname22) {
        this.dsg_sno22 = dsg_sno22;
        this.dsg_sname22 = dsg_sname22;
        this.dsg_ssex22 = dsg_ssex22;
        this.dsg_sage22 = dsg_sage22;
        this.dsg_aname22 = dsg_aname22;
        this.dsg_ssum22 = dsg_ssum22;
        this.dsg_clname22 = dsg_clname22;
    }

    public Student() {
    }
}
