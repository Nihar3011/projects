/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.demo.service;

import com.argus.demo.files.Greetings;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nihar
 */
@Service
public class GreetingsServiceJpaImpl implements GreetingService{
    
    
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Greetings> getGreetings() {
       
        Query query = entityManager.createQuery("from Greetings");

        List<Greetings> Greetings = query.getResultList();

        return Greetings;

    }

    @Override
    public void addUpdateGreeting(Greetings greeting) {
     
           Greetings dbgreeting =entityManager.merge(greeting);

    }
    
}
