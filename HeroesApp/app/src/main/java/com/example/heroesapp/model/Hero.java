package com.example.heroesapp.model;

import com.example.heroesapp.R;

public class Hero {

    private int img;
    private String name;
    private String owner;


    public Hero() {

    }

    public Hero(int img, String name, String owner) {
        this.img = img;
        this.name = name;
        this.owner = owner;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
