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
@Table(name = "billingdetails")
@Inheritance(
       strategy = InheritanceType.JOINED
)
public class BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ownername", length = 30)
    @NotNull
    private String ownername;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private Users user;

    public BillingDetails() {
    }

    public BillingDetails(String ownername) {
        this.ownername = ownername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
    }

}
