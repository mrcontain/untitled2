package com.me.pojo;

public class UserWithFace {
    private String name;
    private String password;
    private String face;

    @Override
    public String toString() {
        return "UserWithFace{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", base64WithFace='" + face + '\'' +
                '}';
    }

    public UserWithFace(String name, String password, String base64WithFace) {
        this.name = name;
        this.password = password;
        this.face = base64WithFace;
    }

    public UserWithFace() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String base64WithFace) {
        this.face = base64WithFace;
    }
}
