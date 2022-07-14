package com.dunderdemo.democlasses;

import com.dunderdb.annotations.Column;
import com.dunderdb.annotations.PrimaryKey;
import com.dunderdb.annotations.Table;

@Table(name = "example4")
public class SerialString {
    @PrimaryKey(name = "id")
    private int id;

    @Column(name = "name", serial = true)
    private String name;

    @Column(name = "phone")
    private int phone;

    public SerialString() {

    }

    public SerialString(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Demo3 [id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }
}
