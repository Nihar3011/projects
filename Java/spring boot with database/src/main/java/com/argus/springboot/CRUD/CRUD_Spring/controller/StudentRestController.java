/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.controller;

import com.argus.springboot.CRUD.CRUD_Spring.exception.StudentNotFoundException;
import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import com.argus.springboot.CRUD.CRUD_Spring.service.StudentServices;
import java.util.List;

import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
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
    @Qualifier("studentJpaRepository")
    private StudentServices studentService;

    @RequestMapping("/student")
    @Transactional
    public List<Student> getStudent() {

        return studentService.getStudents();

    }
    
    @RequestMapping("/student/{studentId}")
    @Transactional
    public Student getStudentById(@PathVariable int studentId) {
        List<Student> ls = studentService.getStudents().
                stream().filter(p -> p.getId() == studentId).collect(Collectors.toList());

        if (ls.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found With Id " + studentId);
        }

        return studentService.getStudentById(studentId);
    }

    @PostMapping("/students")
    @Transactional
    public Student addStudent(@RequestBody Student student) {

        student.setId(0);
        studentService.addUpdateStudent(student);
        return student;
    }

    @PutMapping("/students")
    @Transactional
    public Student updateStudent(@RequestBody Student student) {

        List<Student> ls = studentService.getStudents().
                stream().filter(p -> p.getId() == student.getId()).collect(Collectors.toList());

        if (ls.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found With Id " + student.getId());
        }
        studentService.addUpdateStudent(student);
        return student;
    }

    @DeleteMapping("students/{studentId}")
    @Transactional
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
