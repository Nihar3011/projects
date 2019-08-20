/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nihar
 */
@Service
public class StudentServiceImpl implements StudentServices {

    @Autowired
    private StudentMongoRepository studentMongoRepository;

    @Override
    public List<Student> getStudents() {
        return studentMongoRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return  studentMongoRepository.findById(id).get();
    }

    @Override
    public void addUpdateStudent(Student student) {
            studentMongoRepository.save(student);
    }

    @Override
    public void deleteStudentById(String id) {
            studentMongoRepository.deleteById(id);
    }

}
