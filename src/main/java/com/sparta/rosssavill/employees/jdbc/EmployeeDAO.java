package com.sparta.rosssavill.employees.jdbc;

import java.sql.*;

public class EmployeeDAO {

    // READ
    // UPDATE
    // DELETE

    private Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllEmployees() {
        try {
            ResultSet resultSet = statement.executeQuery("select * from employee_db.employees");
            while(resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createRecord(int employeeId, String prefix, String firstName, String middleInitial, String lastName, String gender, String email, Date dob, Date joinDate, int salary) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `employee_db`.`employees` (`employeeId`, `prefix`, `firstName`, `middleInitial`, `lastName`, `gender`, `email`, `dob`, `joinDate`, `salary`) VALUES (?,?,?,?,?,?,?,?,?,?");
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setString(2, prefix);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, middleInitial);
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setDate(8, dob);
            preparedStatement.setDate(9, joinDate);
            preparedStatement.setInt(10, salary);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}