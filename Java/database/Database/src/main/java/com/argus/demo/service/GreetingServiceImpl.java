/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.demo.service;

import com.argus.demo.files.Greetings;
import com.argus.demo.files.Greetings;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nihar
 */
@Service
public class GreetingServiceImpl implements GreetingService{

    
    @Autowired
    private EntityManager entityManager;

    
    @Override
    public List<Greetings> getGreetings() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Greetings> query = currentSession.createQuery("from Greetings", Greetings.class);

        List<Greetings> Greetings = query.getResultList();
        currentSession.clear();
        return Greetings;
    }

    @Override
    public void addUpdateGreeting(Greetings greeting) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(greeting);
        // currentSession.evict(student);
        currentSession.clear();

    }
    
}
