package com.homeworks.database;


import java.sql.Connection;

import com.mysql.cj.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            Statement statement = connection.createStatement()
//            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Pasha1', 19, 'sol1@gmail.com')");
//            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Pasha2', 39, 'sol2@gmail.com')");
//            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Pasha3', 69, 'sol3@gmail.com')");
//            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

