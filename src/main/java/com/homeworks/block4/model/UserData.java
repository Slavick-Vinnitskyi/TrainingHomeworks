package com.homeworks.block4.model;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class UserData {
    private static final String FILE_OUT = "C:\\Users\\Славик Винницкий\\IdeaProjects\\JavaCourses\\src\\main\\java\\com\\homeworks\\block4\\model\\out.txt";

    private String firstName;
    private String login;
    private String telephone;


    public void setData(String firstName, String login, String telephone) {
        this.firstName = firstName;
        this.login = login;
        this.telephone = telephone;

    }

    public void sendToFile() {
        Writer writer = null;
        try {
            writer = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(FILE_OUT, true), StandardCharsets.UTF_8)));
            writer.write("firstName:" + firstName + " login:" + login + " telephone:" + telephone + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
