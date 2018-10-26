package com.homeworks.enums;

public class Main {
    static Month currentMonth = Month.FEBRUARY;

    public static void main(String[] args) {
        int currentMonthIndex = currentMonth.getMonthIndex();
        int daysInCurrentMonth = currentMonth.getDaysInMonth();
        System.out.println(currentMonth + " index of month : " + currentMonthIndex + " days in that month :" + daysInCurrentMonth);
    }
}
