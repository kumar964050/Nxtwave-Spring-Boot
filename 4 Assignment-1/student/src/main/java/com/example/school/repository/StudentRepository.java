package com.example.school.repository;

import java.util.ArrayList; 
// 
import com.example.school.model.Student;

public interface StudentRepository{
    // api 1
    ArrayList<Student> getAllStudents();
    // api 2
    Student addStudent(Student newStudent);
    // api 3
    String addStudentList(ArrayList<Student> studentList);

    // api 4
    Student getStudentById(int StudentId);
    // api 5
    Student updateStudent(int StudentId, Student modifyStudent);

    // api 6
    void deleteStudent(int StudentId);
}