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
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
/**
 *
 * @author nihar
 */
@Service
public class StudentServiceImpl implements StudentServices {

    @Autowired
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
