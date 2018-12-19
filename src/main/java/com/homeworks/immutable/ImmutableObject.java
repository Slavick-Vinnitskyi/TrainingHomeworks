package com.homeworks.immutable;

public final class ImmutableObject {
    final private Data d;

    public ImmutableObject(Data d) throws CloneNotSupportedException {
        this.d = (Data) d.clone();
    }

    public Data getData() throws CloneNotSupportedException {
        return (Data) d.clone();
    }
}


class Data implements Cloneable {
    private Integer integer;

    public Integer getInteger() {
        return integer;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}