package com.mvc.jpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "greetings")
public class Greetings {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "greeting")
    private String greeting;

    public Greetings(String greeting) {
        this.greeting = greeting;
    }

    public Greetings() {
    }

    
    public Greetings(int id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "greetings{" + "id=" + id + ", greeting=" + greeting + '}';
    }
    
    
}
