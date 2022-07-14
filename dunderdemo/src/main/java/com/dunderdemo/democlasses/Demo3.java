package com.dunderdemo.democlasses;

import com.dunderdb.annotations.Column;
import com.dunderdb.annotations.PrimaryKey;
import com.dunderdb.annotations.Table;

@Table(name = "example3")
public class Demo3 {
    @PrimaryKey(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private int phone;

    public Demo3() {

    }

    public Demo3(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Demo3 [id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

}