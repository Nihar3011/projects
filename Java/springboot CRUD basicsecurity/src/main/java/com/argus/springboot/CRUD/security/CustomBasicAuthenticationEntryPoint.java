/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.security;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 *
 * @author nihar
 */
public class CustomBasicAuthenticationEntryPoint  extends BasicAuthenticationEntryPoint{
    
     @Override
    public void commence(final HttpServletRequest request, 
    		final HttpServletResponse response, 
    		final AuthenticationException authException) throws IOException, ServletException {
    	
    	response.addHeader("WWW-Authenticate", "Basic realm=");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);    
        
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
    }
     @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("Nihar");
        super.afterPropertiesSet();
    }
}
