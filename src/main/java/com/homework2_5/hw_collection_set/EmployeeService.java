package com.homework2_5.hw_collection_set;

import com.homework2_5.hw_collection_set.exceptions.EmployeeAlreadyAddedException;
import com.homework2_5.hw_collection_set.exceptions.EmployeeNotFoundException;
import com.homework2_5.hw_collection_set.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

@Service
public class EmployeeService {
    private final int maxSize;
    private List<Employee> employeesList;

    public EmployeeService() {
        this.employeesList = new ArrayList<>();
        this.maxSize = 5; // максимальный размер массива, проверка на переполнение
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employeesList.size() == maxSize) {
            throw new EmployeeStorageIsFullException("Массив переполнен");
        }
        Employee employee = new Employee(firstName, lastName);

        int index = findIndexOfEmployee(firstName, lastName);
        if (index >= 0 && index < employeesList.size()) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employeesList.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        int index = findIndexOfEmployee(firstName, lastName);
        if (index == -1) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        } else {
            employeesList.remove(index);
            return new Employee(firstName, lastName);
        }
    }

    public int findIndexOfEmployee(String firstName, String lastName) {
        int index = -1;
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).equals(employee)) {
                index = i;
            }
        }

        return index;
    }
    public Employee findEmployee(String firstName, String lastName) {
        int index = findIndexOfEmployee(firstName, lastName);
        if (index == -1) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        } else {
            return new Employee(firstName, lastName);
        }
    }
    public List printEmployees() {
        return employeesList;
    }
}
