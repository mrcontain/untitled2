package com.me.pojo;

public class Reports {
    private String dsg_cname22;
    private String dsg_ccredit22;

    private String dsg_cdate22;
    private String dsg_score22;

    @Override
    public String toString() {
        return "Rrports{" +
                "dsg_cname22='" + dsg_cname22 + '\'' +
                ", dsg_ccredit22='" + dsg_ccredit22 + '\'' +
                ", dsg_cdate22='" + dsg_cdate22 + '\'' +
                ", dsg_score22='" + dsg_score22 + '\'' +
                '}';
    }

    public String getDsg_cname22() {
        return dsg_cname22;
    }

    public void setDsg_cname22(String dsg_cname22) {
        this.dsg_cname22 = dsg_cname22;
    }

    public String getDsg_ccredit22() {
        return dsg_ccredit22;
    }

    public void setDsg_ccredit22(String dsg_ccredit22) {
        this.dsg_ccredit22 = dsg_ccredit22;
    }

    public String getDsg_cdate22() {
        return dsg_cdate22;
    }

    public void setDsg_cdate22(String dsg_cdate22) {
        this.dsg_cdate22 = dsg_cdate22;
    }

    public String getDsg_score22() {
        return dsg_score22;
    }

    public void setDsg_score22(String dsg_score22) {
        this.dsg_score22 = dsg_score22;
    }

    public Reports(String dsg_cname22, String dsg_ccredit22, String dsg_cdate22, String dsg_score22) {
        this.dsg_cname22 = dsg_cname22;
        this.dsg_ccredit22 = dsg_ccredit22;
        this.dsg_cdate22 = dsg_cdate22;
        this.dsg_score22 = dsg_score22;
    }

    public Reports() {
    }
}
