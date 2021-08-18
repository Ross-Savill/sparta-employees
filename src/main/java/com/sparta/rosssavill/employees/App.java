package com.sparta.rosssavill.employees;

import com.sparta.rosssavill.employees.jdbc.ConnectionManager;
import com.sparta.rosssavill.employees.jdbc.EmployeeDAO;

import java.sql.Connection;

public class App {
    public static void main( String[] args ) {

        Run run = new Run();
        run.run();

    }
}
