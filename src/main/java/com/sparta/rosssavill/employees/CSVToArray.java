package com.sparta.rosssavill.employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class CSVToArray {

    public ArrayList<EmployeeDTO> makeEmployeeArray(String fileName) {

        ArrayList<EmployeeDTO> employeeArraylist = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName); // candidates for VAR - JUST FOR READABILITY - this and below
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();

            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] employeeLine = line.split(",");

                EmployeeDTO employee = new EmployeeDTO(employeeLine[0], employeeLine[1],
                        employeeLine[2],employeeLine[3],employeeLine[4],
                        employeeLine[5],employeeLine[6], employeeLine[7],
                        employeeLine[8],employeeLine[9]);
                employeeArraylist.add(employee);
            }

//            Long myList = employeeArraylist.stream().distinct().count(); // Counts distinct
//            System.out.println(myList);

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("File not found");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employeeArraylist;
    }
}
