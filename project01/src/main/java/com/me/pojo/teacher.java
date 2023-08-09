package com.me.pojo;

public class teacher {
    private  String dsg_tno22;
    private  String dsg_tname22;
    private  String dsg_tsex22;
    private Integer dsg_tage22;

    @Override
    public String toString() {
        return "teacher{" +
                "dsg_tno22='" + dsg_tno22 + '\'' +
                ", dsg_tname22='" + dsg_tname22 + '\'' +
                ", dsg_tsex22='" + dsg_tsex22 + '\'' +
                ", dsg_tage22=" + dsg_tage22 +
                ", dsg_tpos22='" + dsg_tpos22 + '\'' +
                ", dsg_tpho22='" + dsg_tpho22 + '\'' +
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

    public String getDsg_tsex22() {
        return dsg_tsex22;
    }

    public void setDsg_tsex22(String dsg_tsex22) {
        this.dsg_tsex22 = dsg_tsex22;
    }

    public Integer getDsg_tage22() {
        return dsg_tage22;
    }

    public void setDsg_tage22(Integer dsg_tage22) {
        this.dsg_tage22 = dsg_tage22;
    }

    public String getDsg_tpos22() {
        return dsg_tpos22;
    }

    public void setDsg_tpos22(String dsg_tpos22) {
        this.dsg_tpos22 = dsg_tpos22;
    }

    public String getDsg_tpho22() {
        return dsg_tpho22;
    }

    public void setDsg_tpho22(String dsg_tpho22) {
        this.dsg_tpho22 = dsg_tpho22;
    }

    public teacher(String dsg_tno22, String dsg_tname22, String dsg_tsex22, Integer dsg_tage22, String dsg_tpos22, String dsg_tpho22) {
        this.dsg_tno22 = dsg_tno22;
        this.dsg_tname22 = dsg_tname22;
        this.dsg_tsex22 = dsg_tsex22;
        this.dsg_tage22 = dsg_tage22;
        this.dsg_tpos22 = dsg_tpos22;
        this.dsg_tpho22 = dsg_tpho22;
    }

    public teacher() {
    }

    private  String dsg_tpos22;
    private  String dsg_tpho22;
}
