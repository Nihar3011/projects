/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.files;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 *
 * @author nihar
 */
@Component
public class StudentMock {

    private ArrayList<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student(1, "Nihar", "Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student(2, "Viren", "Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student(3, "Nikunj", "Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student(4, "Priyam", "Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student(5, "Chandu", "Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
        students.add(new Student(6, "Purvit", "Patel", "9714319500", "patelnihar1997.pn@gmail.com"));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
