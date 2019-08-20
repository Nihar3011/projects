/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author nihar
 */
@Repository
public class StudentService implements StudentServices {

    @Autowired(required = true)
    private EntityManager entityManager;

    @Override
    public List<Student> getStudents() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Student> query = currentSession.createQuery("from Student", Student.class);

        List<Student> student = query.getResultList();
        currentSession.clear();
        return student;
    }

    @Override
    public Student getStudentById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Student student = currentSession.get(Student.class, id);
        currentSession.clear();
        return student;

    }

    @Override
    public void addUpdateStudent(Student student) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(student);
        // currentSession.evict(student);
        currentSession.clear();

    }

    @Override
    public void deleteStudentById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("delete from Student where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        currentSession.clear();

    }

}
