package org.polytech.polyfood;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello");

        String url="jdbc:mysql://localhost:3306/polyfood";

        String username="root";
        String password="rootpw";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO USERS VALUES('abdel2', 'pwd' )";

            connection.createStatement().execute(sql);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
