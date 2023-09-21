package com.example.school.controller;
// 
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
// 
import com.example.school.model.Student;
import com.example.school.service.*;

@RestController
public class StudentController {
    @Autowired
    public StudentH2Service studentService;

    // api 1
    @GetMapping("/students")
    public ArrayList<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    // api 2
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student newStudent){
        return studentService.addStudent(newStudent);
    }
    // api 3
    @PostMapping("/students/bulk")
    public String addStudentList(@RequestBody ArrayList<Student> studentList){
        return studentService.addStudentList(studentList);
     }

    // api 4
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return studentService.getStudentById(studentId);
    }
    // api 5
    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student modifyStudent){
         return studentService.updateStudent(studentId, modifyStudent);
    }
    // api 6
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        studentService.deleteStudent(studentId);
    }


}