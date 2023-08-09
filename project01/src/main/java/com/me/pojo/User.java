package com.me.pojo;

public class User {
    private String dsg_account22;
    private String dsg_password22;

    private String dsg_identity;

    @Override
    public String toString() {
        return "User{" +
                "dsg_account22='" + dsg_account22 + '\'' +
                ", dsg_password22='" + dsg_password22 + '\'' +
                ", dsg_identity='" + dsg_identity + '\'' +
                '}';
    }

    public String getDsg_account22() {
        return dsg_account22;
    }

    public void setDsg_account22(String dsg_account22) {
        this.dsg_account22 = dsg_account22;
    }

    public String getDsg_password22() {
        return dsg_password22;
    }

    public void setDsg_password22(String dsg_password22) {
        this.dsg_password22 = dsg_password22;
    }

    public String getDsg_identity() {
        return dsg_identity;
    }

    public void setDsg_identity(String dsg_identity) {
        this.dsg_identity = dsg_identity;
    }

    public User() {
    }

    public User(String dsg_account22, String dsg_password22, String dsg_identity) {
        this.dsg_account22 = dsg_account22;
        this.dsg_password22 = dsg_password22;
        this.dsg_identity = dsg_identity;
    }
}
