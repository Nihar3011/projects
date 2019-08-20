/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author nihar
 */
@Configuration
@EnableWebSecurity
@Order(99)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("user")
                .and()
                .withUser("admin").password("{noop}admin").roles("admin","user");        
                }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http
          .authorizeRequests().antMatchers("/list/student/*").hasRole("user")
                    .antMatchers("/extra").hasRole("admin")
                  .antMatchers("/list/students").hasRole("admin")
              .antMatchers("/list/students/*").hasRole("admin")
                  .anyRequest()
          .authenticated()
                  .and()
                  .formLogin()
                  .loginPage("/loginPage")
                  .loginProcessingUrl("/authenticateTheUser")
                  .permitAll()
                  .and()
                  .logout().permitAll()
                  .and()
                  .exceptionHandling()
                  .accessDeniedPage("/accessdenied");
          
          
    }
    
    
    
}
