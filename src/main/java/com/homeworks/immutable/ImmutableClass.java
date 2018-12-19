package com.homeworks.immutable;

/**
 * This class can`t be changed because of 'final' keyword
 */
public final class ImmutableClass {
    private int data;
    private String string;

    public ImmutableClass(int data, String string) {
        this.data = data;
        this.string = string;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
