/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.demo.controller;

import com.argus.demo.files.Greetings;
import com.argus.demo.service.GreetingService;
import com.argus.demo.service.GreetingsServiceJpaImpl;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nihar
 */
@RestController
@RequestMapping("/greeting")
public class GreetingsController {
    
    @Autowired
    @Qualifier("greetingServiceImpl")
    private GreetingService greetingsService;
    
    @RequestMapping("/get")
    @Transactional
    public List<Greetings> getStudent() {

        return greetingsService.getGreetings();

    }
    
    @PostMapping("/post")
    @Transactional
    public Greetings addStudent(@RequestBody Greetings greeting) {

        greeting.setId(0);
        greetingsService.addUpdateGreeting(greeting);
        return greeting;
    }
}
