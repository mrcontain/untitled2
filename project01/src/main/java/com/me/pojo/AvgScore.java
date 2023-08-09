package com.me.pojo;

public class AvgScore {
    private String dsg_cname22;
    private String dsg_cno22;
    private Double avggrade;

    @Override
    public String toString() {
        return "AvgScore{" +
                "dsg_cname22='" + dsg_cname22 + '\'' +
                ", dsg_cno22='" + dsg_cno22 + '\'' +
                ", avggrade=" + avggrade +
                '}';
    }

    public String getDsg_cname22() {
        return dsg_cname22;
    }

    public void setDsg_cname22(String dsg_cname22) {
        this.dsg_cname22 = dsg_cname22;
    }

    public String getDsg_cno22() {
        return dsg_cno22;
    }

    public void setDsg_cno22(String dsg_cno22) {
        this.dsg_cno22 = dsg_cno22;
    }

    public Double getAvggrade() {
        return avggrade;
    }

    public void setAvggrade(Double avggrade) {
        this.avggrade = avggrade;
    }

    public AvgScore() {
    }

    public AvgScore(String dsg_cname22, String dsg_cno22, Double avggrade) {
        this.dsg_cname22 = dsg_cname22;
        this.dsg_cno22 = dsg_cno22;
        this.avggrade = avggrade;
    }
}
