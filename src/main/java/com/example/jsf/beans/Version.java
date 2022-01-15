package com.example.jsf.beans;

public class Version {
    private String name;

    public Version(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String download() {
        return "";
    }
}
