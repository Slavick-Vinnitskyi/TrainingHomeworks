package com.homeworks.patterns.creational.abstract_factory.variant1;

import static java.lang.Math.*;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory deviceFactory = getFactoryByCountryCode("ru");
        Mouse mouse = deviceFactory.getMouse();
        Keyboard keyboard = deviceFactory.getKeyboard();
        TouchPad touchPad = deviceFactory.getTouchPad();
        mouse.click();
        mouse.doubleСlick();
        mouse.scroll(34);
        keyboard.print();
        keyboard.printLn();
        touchPad.track(3, 23);
    }

    private static DeviceFactory getFactoryByCountryCode(String language) {
        switch (language.toLowerCase()) {
            case "ru":
                return new RuDeviceFactory();
            case "en":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country :" + language);
        }
    }
}

/**
 * ProductA
 */
interface Mouse {
    void click();

    void doubleСlick();

    void scroll(int direction);
}

/**
 * ProductB
 */
interface Keyboard {
    void print();

    void printLn();
}

/**
 * ProductC
 */
interface TouchPad {
    void track(int deltaX, int deltaY);
}

/**
 * AbstractFactory
 */
interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    TouchPad getTouchPad();
}

/**
 * ConcreteProductA1
 */
class RuMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Щелчёк мыши");
    }

    @Override
    public void doubleСlick() {
        System.out.println("Двойной щелчёк мыши");
    }

    @Override
    public void scroll(int direction) {
        if (direction < 0) {
            System.out.println("Скроллим вниз");
            return;
        } else if (direction > 0) {
            System.out.println("Скроллим вверх");
            return;
        }
        System.out.println("Не скролим");
    }
}

/**
 * ConcreteProductA2
 */
class RuKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.print("Пишем");
    }

    @Override
    public void printLn() {
        System.out.println("Пишем строку");
    }
}

/**
 * ConcreteProductA3
 */
class RuTouchPad implements TouchPad {

    @Override
    public void track(int deltaX, int deltaY) {
        double distance = sqrt(pow(deltaX, 2) + pow(deltaY, 2));
        System.out.println("Передвинулись на " + distance + " пикселей");
    }
}

/**
 * ConcreteProductB1
 */
class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Mouse clicked");
    }

    @Override
    public void doubleСlick() {
        System.out.println("Mouse double clicked");
    }

    @Override
    public void scroll(int direction) {
        if (direction < 0) {
            System.out.println("Scroll down");
            return;
        } else if (direction > 0) {
            System.out.println("Scroll up");
            return;
        }
        System.out.println("Don`t scroll");
    }
}

/**
 * ConcreteProductB2
 */
class EnKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.print("Write down");
    }

    @Override
    public void printLn() {
        System.out.println("Write a string");
    }
}

/**
 * ConcreteProductB3
 */
class EnTouchPad implements TouchPad {

    @Override
    public void track(int deltaX, int deltaY) {
        double distance = sqrt(pow(deltaX, 2) + pow(deltaY, 2));
        System.out.println("Moved on " + distance + " pixels");
    }
}

/**
 * ConcreteFactory1
 */
class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}

/**
 * ConcreteFactory2
 */
class EnDeviceFactory implements DeviceFactory {


    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}