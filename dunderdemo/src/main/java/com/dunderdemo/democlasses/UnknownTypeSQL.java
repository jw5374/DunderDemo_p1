package com.dunderdemo.democlasses;

import com.dunderdb.annotations.Column;
import com.dunderdb.annotations.PrimaryKey;
import com.dunderdb.annotations.Table;

@Table(name = "example5")
public class UnknownTypeSQL {
    @PrimaryKey(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "doesntwork")
    private SerialString somethingWeird;

    public UnknownTypeSQL() {

    }

    public UnknownTypeSQL(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo3 [id=" + id + ", name=" + name + "]";
    }
}

