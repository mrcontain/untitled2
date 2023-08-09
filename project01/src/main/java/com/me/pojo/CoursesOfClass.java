package com.me.pojo;

public class CoursesOfClass {
    private  String dsg_clno22;
    private  String dsg_clname22;
    private  String dsg_cno22;
    private String dsg_cname22;

    private String dsg_cdate22;
    private  Float dsg_ccredit22;
    private  Integer dsg_chour22;

    @Override
    public String toString() {
        return "CoursesOfClass{" +
                "dsg_clno22='" + dsg_clno22 + '\'' +
                ", dsg_clname22='" + dsg_clname22 + '\'' +
                ", dsg_cno22='" + dsg_cno22 + '\'' +
                ", dsg_cname22=" + dsg_cname22 +
                ", dsg_cdate22='" + dsg_cdate22 + '\'' +
                ", dsg_ccredit22='" + dsg_ccredit22 + '\'' +
                ", dsg_chour22='" + dsg_chour22 + '\'' +
                '}';
    }

    public String getDsg_clno22() {
        return dsg_clno22;
    }

    public void setDsg_clno22(String dsg_clno22) {
        this.dsg_clno22 = dsg_clno22;
    }

    public String getDsg_clname22() {
        return dsg_clname22;
    }

    public void setDsg_clname22(String dsg_clname22) {
        this.dsg_clname22 = dsg_clname22;
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


    public String getDsg_cdate22() {
        return dsg_cdate22;
    }

    public void setDsg_cdate22(String dsg_cdate22) {
        this.dsg_cdate22 = dsg_cdate22;
    }

    public Float getDsg_ccredit22() {
        return dsg_ccredit22;
    }

    public void setDsg_ccredit22(Float dsg_ccredit22) {
        this.dsg_ccredit22 = dsg_ccredit22;
    }

    public Integer getDsg_chour22() {
        return dsg_chour22;
    }

    public void setDsg_chour22(Integer dsg_chour22) {
        this.dsg_chour22 = dsg_chour22;
    }

    public void setDsg_cname22(String dsg_cname22) {
        this.dsg_cname22 = dsg_cname22;
    }

    public CoursesOfClass() {
    }

    public CoursesOfClass(String dsg_clno22, String dsg_clname22, String dsg_cno22, String dsg_cname22, String dsg_cdate22, Float dsg_ccredit22, Integer dsg_chour22) {
        this.dsg_clno22 = dsg_clno22;
        this.dsg_clname22 = dsg_clname22;
        this.dsg_cno22 = dsg_cno22;
        this.dsg_cname22 = dsg_cname22;
        this.dsg_cdate22 = dsg_cdate22;
        this.dsg_ccredit22 = dsg_ccredit22;
        this.dsg_chour22 = dsg_chour22;
    }
}
