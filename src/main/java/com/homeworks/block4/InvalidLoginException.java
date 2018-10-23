package com.homeworks.block4;

public class InvalidLoginException extends Exception {

    private String login;

    public InvalidLoginException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
