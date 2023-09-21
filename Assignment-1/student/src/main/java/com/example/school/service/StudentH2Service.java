package com.example.school.service;
// 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
// 
import com.example.school.model.*;
import com.example.school.repository.StudentRepository;

@Service
public class StudentH2Service implements StudentRepository {
    @Autowired
    private JdbcTemplate db;

    // api 1
    @Override
    public ArrayList<Student> getAllStudents(){
        List<Student> studentsList = db.query("select * from student" ,new StudentRowMapper());
        ArrayList<Student> students = new ArrayList<>(studentsList);
        return students;
    }
    // api 2
    public Student addStudent(Student newStudent){
        db.update("insert into student(studentName,gender,standard) values(?,?,?)",
        newStudent.getStudentName(),
        newStudent.getGender(),
        newStudent.getStandard()
        );
        return db.queryForObject("select * from student where studentName =? and gender = ? and standard = ?", 
        new StudentRowMapper(),
        newStudent.getStudentName(),
        newStudent.getGender(),
        newStudent.getStandard()
        );
    }
    // api 3
    public String addStudentList(ArrayList<Student> studentList){
        // 
        for(Student eachStudent : studentList){
            db.update("insert into student(studentName,gender,standard) values(?,?,?)",
            eachStudent.getStudentName(),
            eachStudent.getGender(),
            eachStudent.getStandard()
            );
        }
        return String.format("Successfully added %d students", studentList.size());
    }


    // api 4
    @Override
    public Student getStudentById(int StudentId){
        try{
            return db.queryForObject("select * from student where studentId=?", new StudentRowMapper(), StudentId );
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // api 5
    @Override
    public Student updateStudent(int studentId, Student modifyStudent){
        if(modifyStudent.getStudentName() != null) db.update("update student set studentName=? where studentId=?",modifyStudent.getStudentName(),studentId);
        if(modifyStudent.getGender() != null) db.update("update student set gender=? where studentId=?",modifyStudent.getGender(),studentId);
        if(modifyStudent.getStandard() != 0) db.update("update student set standard=? where studentId=?",modifyStudent.getStandard(),studentId);
        return getStudentById(studentId);
    }

    // api 6
    @Override
    public void  deleteStudent(int StudentId){
        db.update("delete from student where studentId=?",StudentId);
    }

}