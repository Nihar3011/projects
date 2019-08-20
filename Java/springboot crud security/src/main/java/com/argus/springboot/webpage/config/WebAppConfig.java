/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.webpage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author nihar
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.argus.springboot.webpage")
public class WebAppConfig {
    
    @Bean
    public ViewResolver viewResolver(){
        
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        
       
        viewResolver.setSuffix(".jsp");
        
        return viewResolver; 
    } 
    
}
