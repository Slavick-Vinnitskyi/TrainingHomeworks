package com.homeworks.database;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.time.LocalDate;

public class Main {


    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String PHOTO = "C:\\Users\\Славик Винницкий\\IdeaProjects\\JavaCourses\\src\\main\\java\\com\\homeworks\\database\\photo.jpg";
    //    public static void main(String[] args) {
//        DBWorker dbWorker = new DBWorker();
//
//        String query = "select * from new_users WHERE username='Slavick'";
//
//        try {
//            Statement statement = dbWorker.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getInt(1));
//                user.setUsername(resultSet.getString(2));
//                user.setPassword(resultSet.getString(3));
//                System.out.println(user);
//            }
//        }
//         catch (SQLException | NullPointerException exception) {
//
//             System.out.println("SQL Exception");
//             exception.printStackTrace();
//        }
//    }
    private static LocalDate TIME_NOW = LocalDate.now();
    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE_ROW = "DELETE FROM dish WHERE id = ?";

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            preparedStatement = connection.prepareStatement(INSERT_NEW);
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "Inserted title");
//            preparedStatement.setString(3, "Inserted description");
//            preparedStatement.setDouble(4, 0.2f);
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setDate(6, Date.valueOf(TIME_NOW));
//            preparedStatement.setBlob(7, new FileInputStream(PHOTO));
            preparedStatement = connection.prepareStatement(DELETE_ROW);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(GET_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String descr = resultSet.getString("descriprion");
                double rating = resultSet.getDouble("rating");
                boolean published = resultSet.getBoolean("published");
                Date date = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("id:" + id + " title:" + title + " decription:" + descr + " rating:" + rating + " published:" + published + " created:" + date + " icon length:" + icon.length);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
