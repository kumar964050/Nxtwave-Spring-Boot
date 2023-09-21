package com.example.employee.service;
// 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// 
import com.example.employee.model.*;
import com.example.employee.repository.*;

@Service
public class EmployeeH2Service implements EmployeeRepository {


    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Employee> getAllEmployees(){
        List<Employee> empList = db.query("select * from employeelist", new EmployeeRowMapper());
        ArrayList<Employee> emps = new ArrayList<>(empList);
        return emps;
    }   

    @Override
    public Employee addEmployee(Employee newEmp){
        db.update("insert into employeelist(employeeName,email,department) values(?,?,?)",newEmp.getEmployeeName(),newEmp.getEmail(),newEmp.getDepartment());
        return db.queryForObject("select * from employeelist where employeeName=? and email=? and department=?",
        new EmployeeRowMapper(),
        newEmp.getEmployeeName(),
        newEmp.getEmail(),
        newEmp.getDepartment()
        );
    }
    @Override
    public Employee getById(int empId){
        try{
            return db.queryForObject("select * from employeelist where employeeId = ?", new EmployeeRowMapper(),empId); 
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        }
    @Override 
    public Employee updateEmp(int empId, Employee newEmp){
        Employee findEmp = getById(empId);
        if(newEmp.getEmployeeName() != null) db.update("update employeelist set employeeName=? where employeeId=?",newEmp.getEmployeeName(),empId);
        if(newEmp.getEmail() != null) db.update("update employeelist set email=? where employeeId=?",newEmp.getEmail(),empId);
        if(newEmp.getDepartment() != null) db.update("update employeelist set department=? where employeeId=?",newEmp.getDepartment(),empId);
        return getById(empId);
    }

    @Override
    public void deleteEmp(int empId){
        db.update("delete employeelist where employeeId=?",empId);
    }

}
