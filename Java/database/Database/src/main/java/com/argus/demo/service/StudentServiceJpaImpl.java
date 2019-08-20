/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.demo.service;

import com.argus.demo.files.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
/**
 *
 * @author nihar
 */
@Service
public class StudentServiceJpaImpl implements StudentServices {

    @Autowired
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
