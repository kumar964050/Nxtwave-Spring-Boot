package com.example.employee.service;
// 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// 
import com.example.employee.model.Employee;
import com.example.employee.repository.*;

@Service

public class EmployeeJpaService implements EmployeeRepository{
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    // api 1
    @Override
    public ArrayList<Employee> getAllEmployees(){
        List<Employee> empList = employeeJpaRepository.findAll();
        ArrayList<Employee> emps = new ArrayList<>(empList);
        return emps;
    }   

    // api 2
    @Override
    public Employee addEmployee(Employee newEmp){
        employeeJpaRepository.save(newEmp);
        return newEmp;
    }
    // api 3
    @Override
    public Employee getById(int id){
        try{
            return employeeJpaRepository.findById(id).get();
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // api 4
    @Override 
    public Employee updateEmp(int id, Employee newEmp){
       try{
            Employee findEmp =  employeeJpaRepository.findById(id).get();
            if(newEmp.getEmployeeName() != null) findEmp.setEmployeeName(newEmp.getEmployeeName());
            if(newEmp.getEmail() != null) findEmp.setEmail(newEmp.getEmail());
            if(newEmp.getDepartment() != null) findEmp.setDepartment(newEmp.getDepartment());
            employeeJpaRepository.save(findEmp);
            return findEmp;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteEmp(int id){
        try{
            employeeJpaRepository.findById(id).get();
            employeeJpaRepository.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}