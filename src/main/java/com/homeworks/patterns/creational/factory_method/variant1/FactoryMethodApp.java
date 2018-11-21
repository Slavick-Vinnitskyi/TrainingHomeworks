package com.homeworks.patterns.creational.factory_method.variant1;

import java.util.Date;

public class FactoryMethodApp {
    private final static String ROME_MAKER_TYPE = "Rome";
    private final static String DIGITAL_MAKER_TYPE = "Digital";

    public static void main(String[] args) {
        WatchMaker maker = getMaker(ROME_MAKER_TYPE);
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    /**
     * Класс возвращает создателя по его типу
     *
     * @param makerType тип создателя
     * @return создателя по его типу
     */
    private static WatchMaker getMaker(String makerType) {
        if (makerType.equals(ROME_MAKER_TYPE)) {
            return new DigitalWatchMaker();
        } else if (makerType.equals(DIGITAL_MAKER_TYPE)) {
            return new RomeWatchMaker();
        }
        throw new RuntimeException("Не поддерживаемая линия часов :" + makerType);
    }
}

/**
 * Интерфейс сущности
 */
interface Watch {
    void showTime();
}

/**
 * Конкретная сущность
 */
class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

/**
 * Конкретная сущность
 */
class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

/**
 * Интерфейс создателя
 */
interface WatchMaker {
    Watch createWatch();
}

/**
 * Конкретный создатель
 */
class DigitalWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

/**
 * Конкретный создатель
 */
class RomeWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}