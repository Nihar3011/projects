/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.exception.StudentNotFoundException;
import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import com.argus.springboot.CRUD.CRUD_Spring.files.StudentMock;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nihar
 */
@Component
public class StudentService implements StudentServices {

    @Autowired(required = true)
    private StudentMock studentMock;

    @Override
    public ArrayList<Student> getStudents() {
        return studentMock.getStudents();
    }

    @Override
    public Student getStudentById(int id) {
        List<Student> ls = studentMock.getStudents().
                stream().filter(p -> p.getId() == id).collect(Collectors.toList());

        Student student1 = studentMock.getStudents().
                stream().filter(p -> p.getId() == id).findFirst().get();
        //Student student = ls.get(0);
        int index = studentMock.getStudents().indexOf(student1);
        if (ls.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found With Id " + id);
        }
        return studentMock.getStudents().get(index);
    }

    @Override
    public void addStudent(Student student) {
        List<Student> ls = studentMock.getStudents().
                stream().filter(p -> p.getId() == student.getId()).collect(Collectors.toList());
        if (ls.isEmpty()) {
            studentMock.getStudents().add(student);
        } else {
            throw new StudentNotFoundException("Student is present With Id " + student.getId());
        }

    }

    @Override
    public void updateStudent(Student student) {
        List<Student> ls = studentMock.getStudents().
                stream().filter(p -> p.getId() == student.getId()).collect(Collectors.toList());
        Student studentTemp = ls.get(0);
        int index = studentMock.getStudents().indexOf(studentTemp);
        if (ls.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found With Id " + student.getId());
        }

        studentMock.getStudents().set(index, student);

    }

    @Override
    public void deleteStudentById(int id) {
        List<Student> ls = studentMock.getStudents().
                stream().filter(p -> p.getId() == id).collect(Collectors.toList());
        Student student = ls.get(0);
        int index = studentMock.getStudents().indexOf(student);
        if (ls.isEmpty()) {
            throw new StudentNotFoundException("Student Not Found With Id " + id);
        }
        studentMock.getStudents().remove(index);
    }

}
