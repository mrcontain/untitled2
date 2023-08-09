package com.me.pojo;

public class Area {
    private String dsg_aname22;
    private Long numberofpeople;

    public String getDsg_aname22() {
        return dsg_aname22;
    }

    public void setDsg_aname22(String dsg_aname22) {
        this.dsg_aname22 = dsg_aname22;
    }

    public Long getNumberofpeople() {
        return numberofpeople;
    }

    public void setNumberofpeople(Long numberofpeople) {
        this.numberofpeople = numberofpeople;
    }

    public Area(String dsg_aname22, Long numberofpeople) {
        this.dsg_aname22 = dsg_aname22;
        this.numberofpeople = numberofpeople;
    }

    @Override
    public String toString() {
        return "Area{" +
                "dsg_aname22='" + dsg_aname22 + '\'' +
                ", numberofpeople=" + numberofpeople +
                '}';
    }

    public Area() {
    }
}
