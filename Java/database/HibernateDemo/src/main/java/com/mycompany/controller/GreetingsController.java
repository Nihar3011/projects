package com.mycompany.controller;

import com.mycompany.model.Greetings;
import com.mycompany.serviceimpl.GreetingServiceImpl;

/**
 *
 * @author nihar
 */

public class GreetingsController {
    
    private GreetingServiceImpl greetingServiceImpl;

    public GreetingsController() {
        this.greetingServiceImpl = new GreetingServiceImpl();
    }
    
    
    
    public void createHelloWorld(){
        greetingServiceImpl.createHelloWorld(new Greetings("hello"));
    }
    
    public void getHelloWorldById(int id){
        System.out.println(greetingServiceImpl.getHelloWorldById(id));
    }
}
