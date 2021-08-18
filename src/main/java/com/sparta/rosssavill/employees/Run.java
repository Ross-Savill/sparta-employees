package com.sparta.rosssavill.employees;

import com.sparta.rosssavill.employees.jdbc.ConnectionManager;
import com.sparta.rosssavill.employees.jdbc.EmployeeDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class Run {

    public void run() {

        Connection connection = ConnectionManager.connectToDB();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);

        CSVToArray csvtoarray = new CSVToArray();
        ArrayList employeeArrayList = csvtoarray.makeEmployeeArray("src/main/resources/EmployeeRecords.csv");

        EmployeeDTO[] myArray = new EmployeeDTO[employeeArrayList.size() - 1];
        for(int i = 0; i < employeeArrayList.size() - 1; i++) {
            myArray[i] = (EmployeeDTO) employeeArrayList.get(i);
        }

        for(EmployeeDTO employeeDTO : myArray) {
            java.sql.Date sqlDobDate = new java.sql.Date(employeeDTO.getDob().getTime());
            java.sql.Date sqlJoinDate = new java.sql.Date(employeeDTO.getJoinDate().getTime());

            employeeDAO.createRecord(employeeDTO.getEmployeeId(),
                                     employeeDTO.getPrefix(),
                                     employeeDTO.getFirstName(),
                                     employeeDTO.getMiddleInitial(),
                                     employeeDTO.getLastName(),
                                     employeeDTO.getGender(),
                                     employeeDTO.getEmail(),
                                     sqlDobDate,
                                     sqlJoinDate,
                                     employeeDTO.getSalary());
        }
        employeeDAO.printAllEmployees();
        ConnectionManager.closeConnection();
    }
}
