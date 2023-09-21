package com.example.employee;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.*;


@RestController
public class EmployeeController{
    EmployeeService employeeService = new EmployeeService();

    // api 1
    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    // api 2;
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmp){
        return employeeService.addEmployee(newEmp);
        // 
    }
    // api 3
    @GetMapping("/employees/{employeeId}")
    public Employee getEmpById(@PathVariable("employeeId") int employeeId){
         return  employeeService.getById(employeeId);
    }
    // api 4
     @PutMapping("/employees/{employeeId}")
    public Employee updateEmp(@PathVariable("employeeId") int employeeId, @RequestBody Employee newEmp){
        return employeeService.updateEmp(employeeId,  newEmp);
    }
    // api 5
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmp(@PathVariable("employeeId") int employeeId){
        employeeService.deleteEmp(employeeId);
    }
    
}