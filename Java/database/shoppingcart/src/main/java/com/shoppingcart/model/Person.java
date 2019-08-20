package com.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "person")
//@SequenceGenerator(
//        name = "user_address_id_seq",
//        initialValue = 1,
//        sequenceName = "user_address_id_seq"
//)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", length = 15)
    @NotNull
    private String firstname;

    @Column(name = "lastname", length = 15)
    @NotNull
    private String lastname;

    @Column(name = "username", length = 20)
    @NotNull
    private String username;

    @Column(name = "password", length = 20)
    @NotNull
    private String password;

    @Column(name = "email", length = 40)
    @NotNull
    @Email
    private String email;

    @Column(name = "ranking")
    private int ranking;
    
    @Column(name = "admin")
    private boolean admin;

    @OneToMany(cascade = CascadeType.ALL)
//    @CollectionId(
//            columns = @Column(name = "user_address_id"),
//            type = @Type(type = "long"),
//            generator = "user_address_id_seq"
//    )
    @JoinColumn(name = "user_id")
    private List<Address> addresses = new ArrayList<>();
    
    public Person() {
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", email=" + email + ", ranking=" + ranking + ", admin=" + admin + ", addresses=" + addresses + '}';
    }
}
