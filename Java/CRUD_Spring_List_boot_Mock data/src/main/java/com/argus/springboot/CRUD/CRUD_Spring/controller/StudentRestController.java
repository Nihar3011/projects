/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.controller;

import com.argus.springboot.CRUD.CRUD_Spring.exception.StudentNotFoundException;
import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import com.argus.springboot.CRUD.CRUD_Spring.service.StudentServices;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nihar
 */
@RestController
@RequestMapping("/list")
public class StudentRestController {

    @Autowired
    @Qualifier("studentService")
    private StudentServices studentService;

    @RequestMapping("/student")
    public ArrayList<Student> getStudent() {
        return studentService.getStudents();

    }
    @RequestMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        List<Student> ls = studentService.getStudents().
                stream().filter(p -> p.getId() == studentId).collect(Collectors.toList());

        if (ls.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found With Id " + studentId);
        }

        return studentService.getStudentById(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        studentService.addStudent(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {

        studentService.updateStudent(student);
        return student;
    }

    @DeleteMapping("students/{studentId}")
    public String deleteStudentById(@PathVariable int studentId) {

        List<Student> ls = studentService.getStudents().
                stream().filter(p -> p.getId() == studentId).collect(Collectors.toList());

        if (ls.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found With Id " + studentId);
        }
        studentService.deleteStudentById(studentId);
        return "Delete Student id: " + studentId;
    }
}
