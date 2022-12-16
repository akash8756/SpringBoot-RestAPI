package com.spring.security.controller;

import com.spring.security.model.Student;
import com.spring.security.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class StudentConttroller {

    @Autowired
    private final StudentService studentService;

    public StudentConttroller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable ("id") Long id){
        return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.OK);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        log.info(student);
    }

    @DeleteMapping
    public void deleteStudent(@PathVariable("id") Long id){
        log.info(id);
    }

    @PutMapping
    public void updateStudent(@PathVariable("id") Long id, @RequestBody  Student student){
        log.info(String.format("%s %s", student, student));
    }
}
