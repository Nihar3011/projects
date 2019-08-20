/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author nihar
 */
@Repository
public class StudentServiceJpa implements StudentServices {

    @Autowired(required = true)
    private EntityManager entityManager;

    @Override
    public List<Student> getStudents() {

        Query query = entityManager.createQuery("from Student");

        List<Student> students = query.getResultList();

        return students;

    }

    @Override
    public Student getStudentById(int id) {

        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public void addUpdateStudent(Student student) {

            Student dbstudent =entityManager.merge(student);
            student.setId(dbstudent.getId());
    }

    @Override
    public void deleteStudentById(int id) {

            Query query=entityManager.createQuery("delete from Student where id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
    }

}
