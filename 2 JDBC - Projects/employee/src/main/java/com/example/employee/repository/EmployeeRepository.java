package com.example.employee.repository;

import java.util.ArrayList;
import com.example.employee.model.*;

public interface EmployeeRepository{
    ArrayList<Employee> getAllEmployees();
    Employee addEmployee(Employee newEmp);
    Employee getById(int empId);
    Employee updateEmp(int empId, Employee newEmp);
    void deleteEmp(int empId);
    
}