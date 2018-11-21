package com.homeworks.patterns.creational.factory_method.variant1;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker maker = getMaker("Rome");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMaker(String makerType) {
        if (makerType.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (makerType.equals("Rome")) {
            return new RomeWatchMaker();
        }
        throw new RuntimeException("Не поддерживаемая линия часов :" + makerType);
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}

