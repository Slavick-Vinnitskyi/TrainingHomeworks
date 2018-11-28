package com.homeworks.patterns.behavioral.template_method;

public class TemplateMethodApp {
    public static void main(String[] args) {
        A a = new A();
        a.templateMethod();
        System.out.println();
        B b = new B();
        b.templateMethod();

    }
}

abstract class Parent {
    abstract void differ();

    void templateMethod() {
        System.out.print("1");
        differ();
        System.out.print("3");
    }
}

class A extends Parent {

    @Override
    void differ() {
        System.out.print("2");
    }
}

class B extends Parent {

    @Override
    void differ() {
        System.out.print("4");
    }
}
