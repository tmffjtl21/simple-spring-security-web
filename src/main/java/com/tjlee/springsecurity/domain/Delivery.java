package com.tjlee.springsecurity.domain;

import javax.persistence.*;
import java.util.Objects;

//@Entity
public class Delivery {
    private int delivertyId;
    private String city;
    private String street;
    private String zipcode;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERTY_ID", nullable = false)
    public int getDelivertyId() {
        return delivertyId;
    }

    public void setDelivertyId(int delivertyId) {
        this.delivertyId = delivertyId;
    }

    @Basic
    @Column(name = "CITY", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "STREET", nullable = true, length = 45)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "ZIPCODE", nullable = true, length = 45)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return delivertyId == delivery.delivertyId &&
                Objects.equals(city, delivery.city) &&
                Objects.equals(street, delivery.street) &&
                Objects.equals(zipcode, delivery.zipcode) &&
                Objects.equals(status, delivery.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delivertyId, city, street, zipcode, status);
    }
}
