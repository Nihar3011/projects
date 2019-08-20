/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.controller;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import com.argus.springboot.CRUD.CRUD_Spring.service.MongoDbQuery;
import com.argus.springboot.CRUD.CRUD_Spring.service.StudentServices;
import java.util.List;
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
    private StudentServices studentService;
     @Autowired
     private MongoDbQuery mongoDbQuery;
             
    @RequestMapping("/student")
    @Transactional
    public List<Student> getStudent() {
        return studentService.getStudents();

    }

    @RequestMapping("/student/{studentId}")
    @Transactional
    public Student getStudentById(@PathVariable String studentId) {

        return studentService.getStudentById(studentId);
    }

    @PostMapping("/students")
    @Transactional
    public Student addStudent(@RequestBody Student student) {
        studentService.addUpdateStudent(student);
        return student;
    }

    @PutMapping("/students")
    @Transactional
    public Student updateStudent(@RequestBody Student student) {

        studentService.addUpdateStudent(student);
        return student;
    }

    
    @DeleteMapping("students/{studentId}")
    @Transactional
    public String deleteStudentById(@PathVariable String studentId) {

        studentService.deleteStudentById(studentId);
        return "Delete Student id: " + studentId;
    }

    @RequestMapping("/extra/{studentName}")
    @Transactional
    public Student getExtra(@PathVariable String studentName) {
       
        return mongoDbQuery.findOneByFirstName(studentName);

    }
    
    @RequestMapping("/abc/{studentName1}")
    @Transactional
    public List<Student> getAllByName(@PathVariable String studentName1) {
       
        return mongoDbQuery.findAllByFirstName(studentName1);

    }

}
