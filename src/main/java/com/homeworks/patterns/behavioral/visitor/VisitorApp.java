package com.homeworks.patterns.behavioral.visitor;

public class VisitorApp {
    public static void main(String[] args) {
        Element element = new BodyElement();
        Element element1 = new EngineElement();

        element.accept(new HooliganVisitor());
        element.accept(new MechanicVisitor());
        element1.accept(new HooliganVisitor());
        element1.accept(new MechanicVisitor());

    }
}

interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement body);
}


interface Element {
    void accept(Visitor visitor);
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по кузову");
    }
}

class MechanicVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Проверил кузов");
    }
}
