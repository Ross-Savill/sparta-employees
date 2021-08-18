package com.sparta.rosssavill.employees.jdbc;

import java.sql.*;

public class ConnectionManager {

    private static Connection connection;

    public static Connection connectToDB() {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String userName = "";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
