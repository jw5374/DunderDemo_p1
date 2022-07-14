package com.dunderdemo.democlasses;

import com.dunderdb.annotations.Column;
import com.dunderdb.annotations.PrimaryKey;

public class NoTable {
    @PrimaryKey(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private int phone;

    public NoTable() {

    }

    public NoTable(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Demo3 [id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }
}
