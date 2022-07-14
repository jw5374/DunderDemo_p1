package com.dunderdemo.democlasses;

import java.sql.Timestamp;

import com.dunderdb.annotations.*;

@Table(name = "example")
public class Demo {
    @PrimaryKey(name = "id", serial = true)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private double balance;

    @Column(name = "timecreated")
    private Timestamp timecreated;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "secondssincecreation")
    private long secondsSince;

    public Demo() {

    }

    public Demo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Demo(String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public Demo(String name, String email, double balance, boolean isActive) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Demo [balance=" + balance + ", email=" + email + ", id=" + id + ", isActive=" + isActive + ", name="
                + name + ", secondsSince=" + secondsSince + ", timecreated=" + timecreated + "]";
    }
    
 
}
