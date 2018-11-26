package com.homeworks.patterns.creational.prototype.university_variant;

public interface Copyable extends Cloneable {
    Object copy() throws CloneNotSupportedException;

    Object deepCopy();
}
