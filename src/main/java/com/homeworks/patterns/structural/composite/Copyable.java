package com.homeworks.patterns.structural.composite;

public interface Copyable extends Cloneable {
    Object copy() throws CloneNotSupportedException;

    Object deepCopy();
}
