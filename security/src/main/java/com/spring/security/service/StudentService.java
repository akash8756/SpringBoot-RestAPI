package com.spring.security.service;

import com.spring.security.model.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private List<Student> studentList = Arrays.asList(
            new Student(1L, "Rakesh"),
            new Student(2L, "Suchit")
    );

    public Student getStudent(Long studentId){
        Student studentIdNotFound = studentList.stream( )
                .filter(student -> student.getStudentId( ) == studentId)
                .findFirst( )
                .orElseThrow(( ) -> new IllegalArgumentException("student id not found "));
        return studentIdNotFound;
    }
}
