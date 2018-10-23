package com.homeworks.block4.model;

public class Model {
    UserData table;

    public Model(UserData table) {
        this.table = table;
    }

    public void setTable(String firstName, String login, String telephone) {
        table.setData(firstName, login, telephone);
    }

    public void sendToFile() {
        table.sendToFile();
    }
}
