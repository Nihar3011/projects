/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import java.util.ArrayList;
/**
 *
 * @author nihar
 */
public interface StudentServices {

    public ArrayList<Student> getStudents();
    public Student getStudentById(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudentById(int id);
}
