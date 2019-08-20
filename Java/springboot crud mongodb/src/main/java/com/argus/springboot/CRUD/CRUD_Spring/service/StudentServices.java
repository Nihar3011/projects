/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import java.util.List;
/**
 *
 * @author nihar
 */
public interface StudentServices {

    public List<Student> getStudents();
    public Student getStudentById(String id);
    public void addUpdateStudent(Student student);
    public void deleteStudentById(String id);
  
}
