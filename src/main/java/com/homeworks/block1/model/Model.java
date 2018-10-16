package com.homeworks.block1.model;

public class Model {

    private String helloString;

    public void completeString(String hello, String world) {
        helloString = hello + " " + world;
    }

    public String getHelloString() {
        return helloString;
    }
}
