package com.me.pojo;

public class TeacherGrade {
    private String dsg_cno22;
    private String dsg_cname22;
    private String dsg_sno22;
    private String dsg_sname22;
    private Double dsg_score22;

    @Override
    public String toString() {
        return "TeacherGrade{" +
                "dsg_cno22='" + dsg_cno22 + '\'' +
                ", dsg_cname22='" + dsg_cname22 + '\'' +
                ", dsg_sno22='" + dsg_sno22 + '\'' +
                ", dsg_sname22='" + dsg_sname22 + '\'' +
                ", dsg_score22=" + dsg_score22 +
                '}';
    }

    public String getDsg_cname22() {
        return dsg_cname22;
    }

    public void setDsg_cname22(String dsg_cname22) {
        this.dsg_cname22 = dsg_cname22;
    }

    public TeacherGrade(String dsg_cno22, String dsg_cname22, String dsg_sno22, String dsg_sname22, Double dsg_score22) {
        this.dsg_cno22 = dsg_cno22;
        this.dsg_cname22 = dsg_cname22;
        this.dsg_sno22 = dsg_sno22;
        this.dsg_sname22 = dsg_sname22;
        this.dsg_score22 = dsg_score22;
    }

    public String getDsg_cno22() {
        return dsg_cno22;
    }

    public void setDsg_cno22(String dsg_cno22) {
        this.dsg_cno22 = dsg_cno22;
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

    public Double getDsg_score22() {
        return dsg_score22;
    }

    public void setDsg_score22(Double dsg_score22) {
        this.dsg_score22 = dsg_score22;
    }

    public TeacherGrade() {
    }

    public TeacherGrade(String dsg_cno22, String dsg_sno22, String dsg_sname22, Double dsg_score22) {
        this.dsg_cno22 = dsg_cno22;
        this.dsg_sno22 = dsg_sno22;
        this.dsg_sname22 = dsg_sname22;
        this.dsg_score22 = dsg_score22;
    }
}
