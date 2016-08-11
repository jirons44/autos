package com.jihs.models;


import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "Clients")
@Access(AccessType.PROPERTY)
public class Client {
    private int id;
    private String name;
    private String AddressLine1;
    private String AddressLine2;
    private String City;
    private String StateCode;

    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name", nullable = false, unique = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "addressLine1", nullable = true, unique = false, length = 45)
    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "addressLine2", nullable = true, unique = false, length = 45)
    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    @Basic
    @Column(name = "city", nullable = true, unique = false, length = 45)
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Basic
    @Column(name = "stateCode", nullable = true, unique = false, length = 2)
    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }
}
