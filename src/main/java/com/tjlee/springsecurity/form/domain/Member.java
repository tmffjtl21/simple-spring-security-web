package com.tjlee.springsecurity.form.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

//@Entity
public class Member {
    private int memberId;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID", nullable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId &&
                Objects.equals(name, member.name) &&
                Objects.equals(city, member.city) &&
                Objects.equals(street, member.street) &&
                Objects.equals(zipcode, member.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, city, street, zipcode);
    }
}
