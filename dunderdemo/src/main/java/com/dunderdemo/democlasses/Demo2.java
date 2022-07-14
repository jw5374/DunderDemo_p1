package com.dunderdemo.democlasses;

import com.dunderdb.annotations.Column;
import com.dunderdb.annotations.ForeignKey;
import com.dunderdb.annotations.PrimaryKey;
import com.dunderdb.annotations.Table;

@Table(name = "example2")
public class Demo2 {
    @PrimaryKey(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // from the table named 'example', we are referencing its 'id' column
    @ForeignKey(name = "demo1id", references = "example(id)")
    private int demo1id;

    public Demo2() {

    }

    public Demo2(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Demo2 [demo1id=" + demo1id + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDemo1id() {
        return demo1id;
    }

    public void setDemo1id(int demo1id) {
        this.demo1id = demo1id;
    }

}