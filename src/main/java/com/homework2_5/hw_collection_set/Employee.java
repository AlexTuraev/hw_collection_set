package com.homework2_5.hw_collection_set;

public class Employee {
    protected String firstName;
    protected String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return getFirstName() + " " + getLastName();
    }

    public Boolean equals(Employee employee) {
        if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
            return true;
        } else {
            return false;
        }
    }
}
