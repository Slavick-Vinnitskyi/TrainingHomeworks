package com.homeworks.enums;

public enum Month {
    JANUARY(1, 31), FEBRUARY(2, 28), MARCH(3, 31);

    private int monthIndex;
    private int daysInMonth;

    Month(int monthIndex, int daysInMonth) {
        this.monthIndex = monthIndex;
        this.daysInMonth = daysInMonth;
    }

    int getMonthIndex() {
        return monthIndex;
    }

    int getDaysInMonth() {
        return daysInMonth;
    }
}
