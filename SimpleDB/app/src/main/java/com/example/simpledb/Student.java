package com.example.simpledb;

public class Student {

    private int id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
