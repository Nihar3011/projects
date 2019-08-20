/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.google;

import static java.util.Objects.isNull;
import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author nihar
 */
@Configuration
@ConfigurationProperties(prefix = "spring.social.google")
public class GoogleIdentifierProperties {

    @Nonnull
    private String[] clients;

    @Nonnull
    private String issuer;

    public String[] getClients() {
        return clients;
    }

    public void setClients(String[] clients) {
        this.clients = clients;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @PostConstruct
    public void init() {
        if (isNull(issuer)) {
            issuer = "https://accounts.google.com";
        }
    }
}
