package com.example.employee;

import java.util.ArrayList;
import com.example.employee.Employee;

public interface EmployeeRepository{
    ArrayList<Employee> getAllEmployees();
    Employee addEmployee(Employee newEmp);
    Employee getById(int empId);
    Employee updateEmp(int empId, Employee newEmp);
    void deleteEmp(int empId);
    
}