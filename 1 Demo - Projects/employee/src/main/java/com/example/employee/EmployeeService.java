

package com.example.employee;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;

import java.util.*;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();
    private int unqId = 7;

    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    @Override
    public ArrayList<Employee> getAllEmployees(){
        Collection<Employee> empCollection = employeeList.values();
        ArrayList<Employee> empList = new ArrayList<>(empCollection);
        return empList;
    }
    @Override
    public Employee addEmployee(Employee newEmp){
        newEmp.setEmployeeId(unqId);
        employeeList.put(unqId,newEmp);
        unqId +=1;
        return newEmp;
    }
    @Override
    public Employee getById(int empId){
        Employee findEmp = employeeList.get(empId);
        if(findEmp == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return findEmp;
    }
    @Override 
    public Employee updateEmp(int empId, Employee newEmp){
        Employee findEmp = employeeList.get(empId);
        if(findEmp == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(newEmp.getEmployeeName() != null) findEmp.setEmployeeName(newEmp.getEmployeeName());
        if(newEmp.getEmail() != null) findEmp.setEmail(newEmp.getEmail());
        if(newEmp.getDepartment() != null) findEmp.setDepartment(newEmp.getDepartment());
        return findEmp;
    }

    @Override
    public void deleteEmp(int empId){
         Employee findEmp = employeeList.get(empId);
        if(findEmp == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else{
            employeeList.remove(empId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
    

}
