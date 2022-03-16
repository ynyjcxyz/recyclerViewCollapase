package com.codixlab.collapsingrecyclerview.model;

public class Person {

    private final String name;
    private final int image;

    public Person(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }


    public String getName() {
        return name;
    }


}