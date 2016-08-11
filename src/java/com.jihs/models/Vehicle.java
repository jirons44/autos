package com.jihs.models;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "vehicles")
@Access(AccessType.PROPERTY)
public class Vehicle {
    private int id;
    private String make;
    private String model;
    private int year;
    private int mileage;
    private int milesDriven;
    private Client client;

    public Vehicle() {
    }

    public Vehicle(String make, String model, int year, Client client) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.client = client;
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
    @Column(name = "make", nullable = false, unique = false, length = 45)
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "model", nullable = false, unique = false, length = 45)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "year", nullable = false, unique = false)
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "mileage", nullable = true, unique = false)
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Basic
    @Column(name = "milesDriven", nullable = true, unique = false)
    public int getMilesDriven() {
        return milesDriven;
    }
    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public Client   getClient() {
        return client;
    }
    public void     setClient(Client client) {
        this.client = client;
    }
}
