package org.polytech.polyfood;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/polyfood";
        String username = "root";
        String password = "rootpw";
        System.out.println("Hello World");
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM USERS";

            // execute --> update, delete, insert
            // executeQuery --> select

            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            // resultSet is the result of select query
            while (resultSet.next()) {
                System.out.println("username:" + resultSet.getString("username") + ",password:" + resultSet.getString("password"));
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
