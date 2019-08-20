    package com.shoppingcart.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "street", length = 30)
    @NotNull
    private String street;

    @Column(name = "zipcode", length = 6)
    @NotNull
    @Min(value = 6)
    private String zipcode;

    @Column(name = "city", length = 20)
    @NotNull
    private String city;

    @Column(name = "type")
    @NotNull
    private AddressType type;

    @OneToOne(cascade = CascadeType.ALL)
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public Address(String street, String zipcode, String city, AddressType type) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
    }

}
