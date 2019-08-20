package com.shoppingcart.model;

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
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "inspectionperioddays")
    @NotNull
    private int inspectionperioddays;

    @Column(name = "state")
    @NotNull
    private ShipmentState state;

    @Column(name = "created")
    @CreationTimestamp
    @NotNull
    private LocalDate created;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", nullable = false)
    private Users buyer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", nullable = false)
    private Users seller;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address dilivery;

    public Shipment() {
    }

    public Shipment(int inspectionperioddays, ShipmentState state, LocalDate created) {
        this.inspectionperioddays = inspectionperioddays;
        this.state = state;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getInspectionperioddays() {
        return inspectionperioddays;
    }

    public void setInspectionperioddays(int inspectionperioddays) {
        this.inspectionperioddays = inspectionperioddays;
    }

    public ShipmentState getState() {
        return state;
    }

    public void setState(ShipmentState state) {
        this.state = state;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Item getItem_id() {
        return item_id;
    }

    public void setItem_id(Item item_id) {
        this.item_id = item_id;
    }

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public Address getDilivery() {
        return dilivery;
    }

    public void setDilivery(Address dilivery) {
        this.dilivery = dilivery;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
    }

}
