package com.sparta.rosssavill.employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class EmployeeDTO implements Comparable {

    private String prefix, firstName, middleInitial, lastName, gender, email;
    private int employeeId, salary;
    private Date dob, joinDate;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public EmployeeDTO(String givenEmployeeId, String givenPrefix, String givenFirstName,
                       String givenMiddleInitial, String givenLastName, String givenGender,
                       String givenEmail, String givenDob, String givenJoinDate,
                       String givenSalary) throws ParseException {

        this.employeeId = Integer.parseInt(givenEmployeeId);
        this.prefix = givenPrefix;
        this.firstName = givenFirstName;
        this.middleInitial = givenMiddleInitial;
        this.lastName = givenLastName;
        this.gender = givenGender;
        this.email = givenEmail;
        this.dob = simpleDateFormat.parse(givenDob);
        this.joinDate = simpleDateFormat.parse(givenJoinDate);
        this.salary = Integer.parseInt(givenSalary);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return this.employeeId == ((EmployeeDTO) obj).employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
