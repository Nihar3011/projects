/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.google;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author nihar
 */
@Configuration
@ConditionalOnClass({GoogleIdentifierProperties.class})
@EnableConfigurationProperties(GoogleIdentifierProperties.class)
public class GoogleIdentifierConfiguration {
    
      private final GoogleIdentifierProperties googleIdentifierProperties;

    @Autowired
    public GoogleIdentifierConfiguration(GoogleIdentifierProperties googleIdentifierProperties) {
        this.googleIdentifierProperties = googleIdentifierProperties;
    }

    @Bean
    public GoogleIdTokenVerifier googleIdTokenVerifier(JacksonFactory jacksonFactory, HttpTransport httpTransport) {
        return new GoogleIdTokenVerifier.Builder(httpTransport, jacksonFactory)
                .setIssuer(googleIdentifierProperties.getIssuer())
                .setAudience(Arrays.asList(googleIdentifierProperties.getClients()))
                .build();
    }

    @Bean
    public JacksonFactory jacksonFactory() {
        return new JacksonFactory();
    }

    @Bean
    public HttpTransport httpTransport() {
        return new NetHttpTransport();
    }

    @Bean
    public GoogleTokenVerifierTemplate googleTokenVerifierTemplate(GoogleIdTokenVerifier googleIdTokenVerifier) {
        return new GoogleTokenVerifierTemplate(googleIdTokenVerifier);
}
    
}
