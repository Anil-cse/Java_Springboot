package com.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

    public static final String URl = "jdbc:mysql://localhost:3306/Callable";
    public static final String UserName = "root";
    public static final String Password = "Ag3484e@";

    public static Connection connection = null;

    private MySqlConnection() {

    }

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URl, UserName, Password);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return connection;

    }

}
