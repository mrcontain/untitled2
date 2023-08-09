package com.me.pojo;

public class Filter {
    private String text;
    private String value;

    @Override
    public String toString() {
        return "filter{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Filter() {
    }

    public Filter(String text, String value) {
        this.text = text;
        this.value = value;
    }
}
