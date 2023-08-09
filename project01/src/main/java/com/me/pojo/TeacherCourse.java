package com.me.pojo;

public class TeacherCourse {
    private String dsg_tno22;
    private String dsg_tname22;
    private String dsg_cno22;
    private String dsg_cname22;
    private Double dsg_ccredit22;
    private Integer dsg_chour22;

    @Override
    public String toString() {
        return "TeacherCourse{" +
                "dsg_tno22='" + dsg_tno22 + '\'' +
                ", dsg_tname22='" + dsg_tname22 + '\'' +
                ", dsg_cno22='" + dsg_cno22 + '\'' +
                ", dsg_cname22='" + dsg_cname22 + '\'' +
                ", dsg_ccredit22=" + dsg_ccredit22 +
                ", dsg_chour22=" + dsg_chour22 +
                '}';
    }

    public String getDsg_tno22() {
        return dsg_tno22;
    }

    public void setDsg_tno22(String dsg_tno22) {
        this.dsg_tno22 = dsg_tno22;
    }

    public String getDsg_tname22() {
        return dsg_tname22;
    }

    public void setDsg_tname22(String dsg_tname22) {
        this.dsg_tname22 = dsg_tname22;
    }

    public String getDsg_cno22() {
        return dsg_cno22;
    }

    public void setDsg_cno22(String dsg_cno22) {
        this.dsg_cno22 = dsg_cno22;
    }

    public String getDsg_cname22() {
        return dsg_cname22;
    }

    public void setDsg_cname22(String dsg_cname22) {
        this.dsg_cname22 = dsg_cname22;
    }

    public Double getDsg_ccredit22() {
        return dsg_ccredit22;
    }

    public void setDsg_ccredit22(Double dsg_ccredit22) {
        this.dsg_ccredit22 = dsg_ccredit22;
    }

    public Integer getDsg_chour22() {
        return dsg_chour22;
    }

    public void setDsg_chour22(Integer dsg_chour22) {
        this.dsg_chour22 = dsg_chour22;
    }

    public TeacherCourse() {
    }

    public TeacherCourse(String dsg_tno22, String dsg_tname22, String dsg_cno22, String dsg_cname22, Double dsg_ccredit22, Integer dsg_chour22) {
        this.dsg_tno22 = dsg_tno22;
        this.dsg_tname22 = dsg_tname22;
        this.dsg_cno22 = dsg_cno22;
        this.dsg_cname22 = dsg_cname22;
        this.dsg_ccredit22 = dsg_ccredit22;
        this.dsg_chour22 = dsg_chour22;
    }
}
