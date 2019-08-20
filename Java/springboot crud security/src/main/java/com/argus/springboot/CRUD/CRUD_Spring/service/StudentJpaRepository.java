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
public class StudentJpaRepository implements StudentServices {
     
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void addUpdateStudent(Student student) {

        studentRepository.save(student);
       
    }

    @Override
    public void deleteStudentById(int id) {
         studentRepository.deleteById(id);
    }
}
