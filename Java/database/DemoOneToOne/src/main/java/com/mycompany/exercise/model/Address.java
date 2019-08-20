package com.mycompany.exercise.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 *
 * @author nihar
 */
@Embeddable
public class Address {


    @Column(name = "street1", length = 20)
    private String street1;

    @Column(name = "street2", length = 20)
    private String street2;

    @Column(name = "city", length = 15)
    private String city;

    @Column(name = "state", length = 15)
    private String state;
    
    @Column(name = "county", length = 15)
    private String county;


    public Address() {
    }

    public Address( String street1, String street2, String city, String state, String county) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.county = county;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

  
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
    
    
    
    
    
}
