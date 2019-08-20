/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.controller;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import com.argus.springboot.CRUD.CRUD_Spring.google.GoogleTokenVerifierTemplate;
import com.argus.springboot.CRUD.CRUD_Spring.google.Token;
import com.argus.springboot.CRUD.CRUD_Spring.google.User;
import com.argus.springboot.CRUD.CRUD_Spring.service.StudentServices;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import static java.util.Objects.isNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nihar
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/list")
public class StudentRestController {

    private static final Logger logger = LoggerFactory.getLogger(StudentRestController.class);
   
    @Autowired
    private StudentServices studentService;
    
      private GoogleTokenVerifierTemplate googleTokenVerifierTemplate;

    @Autowired
    public StudentRestController(GoogleTokenVerifierTemplate googleTokenVerifierTemplate) {
        this.googleTokenVerifierTemplate = googleTokenVerifierTemplate;
}
        
    @RequestMapping("/student")
    @Transactional
    public List<Student> getStudent() { 
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
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

    @PutMapping("/students/{userId}")
    @Transactional
    public Student updateStudent(@PathVariable String userId,@RequestBody Student student) {
        
        System.out.println(student);
        System.out.println(userId);
        
           student.setId(userId);
        studentService.addUpdateStudent(student);
        return student;
    }

    
    @DeleteMapping("students/{studentId}")
    @Transactional
    public String deleteStudentById(@PathVariable String studentId) {

        studentService.deleteStudentById(studentId);
        return null;
    }
    
     @RequestMapping(value = "/email", method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody User verifyToken(@RequestBody String idToken) throws GeneralSecurityException, IOException {
         System.out.println(idToken);
        GoogleIdToken googleIdToken = googleTokenVerifierTemplate.verify(idToken);
        if (isNull(googleIdToken)) {
            throw new RuntimeException("Unauthenticated User by google");
        }
        GoogleIdToken.Payload payload = googleIdToken.getPayload();
        return new User((String) payload.get("given_name"), (String) payload.get("family_name"));
}
}
