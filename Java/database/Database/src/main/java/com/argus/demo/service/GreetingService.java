/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.demo.service;

import com.argus.demo.files.Greetings;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface GreetingService {
    
     public List<Greetings> getGreetings();
     
      public void addUpdateGreeting(Greetings greeting);
}
