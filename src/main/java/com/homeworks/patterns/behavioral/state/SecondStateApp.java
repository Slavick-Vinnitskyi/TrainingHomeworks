package com.homeworks.patterns.behavioral.state;

public class SecondStateApp {
    public static void main(String[] args) {
        Human Slavick = new Human();
        Slavick.setState(new Working());
        for (int i = 0; i < 10; i++) {
            Slavick.doSomething();
        }
    }
}

class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

interface Activity {
    void doSomething(Human context);
}

class Working implements Activity {

    @Override
    public void doSomething(Human context) {
        System.out.println("Working");
        context.setState(new Resting());
    }
}

class Resting implements Activity {
    private int count = 0;

    @Override
    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Resting");
            count++;
        } else {
            context.setState(new Working());
        }
    }
}
