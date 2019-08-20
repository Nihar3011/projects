package com.shoppingcart.model;

import java.time.LocalDateTime;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "item")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", length = 50)
    @NotNull
    private String name;
    
    @Column(name = "description")
    @NotNull
    private String description;
    
    @Column(name = "intialprice")
    @NotNull
    private Long intialprice;
    
    @Column(name = "reserveprice")
    private Long reserveprice;
    
    @Column(name = "startdate")
    @CreationTimestamp
    @NotNull
    private LocalDate startdate;
    
    @Column(name = "enddate")
    @CreationTimestamp
    @NotNull
    private LocalDate enddate;
    
    @Column(name = "state")
    @NotNull
    private ItemState state;
    
    @Column(name = "approvaldatetime")
    @CreationTimestamp
    @NotNull
    private LocalDateTime approvaldatetime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users saller;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }    

    public Item(String name, String description, Long intialprice, Long reserveprice, LocalDate startdate, LocalDate enddate, ItemState state, LocalDateTime approvaldatetime, Category category) {
        this.name = name;
        this.description = description;
        this.intialprice = intialprice;
        this.reserveprice = reserveprice;
        this.startdate = startdate;
        this.enddate = enddate;
        this.state = state;
        this.approvaldatetime = approvaldatetime;
        this.category = category;
    }
    
    

    public Item() {
    }

    public Users getSaller() {
        return saller;
    }

    public void setSaller(Users saller) {
        this.saller = saller;
    }    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIntialprice() {
        return intialprice;
    }

    public void setIntialprice(Long intialprice) {
        this.intialprice = intialprice;
    }

    public Long getReserveprice() {
        return reserveprice;
    }

    public void setReserveprice(Long reserveprice) {
        this.reserveprice = reserveprice;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public ItemState getState() {
        return state;
    }

    public void setState(ItemState state) {
        this.state = state;
    }

    public LocalDateTime getApprovaldatetime() {
        return approvaldatetime;
    }

    public void setApprovaldatetime(LocalDateTime approvaldatetime) {
        this.approvaldatetime = approvaldatetime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
    }
}
