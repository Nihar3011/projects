package com.mvc.jpademo.controller;

import com.mvc.jpademo.model.Greetings;
import com.mvc.jpademo.serviceimpl.GreetingServiceImpl;

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
    
   
}
