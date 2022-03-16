package com.codixlab.collapsingrecyclerview.model;

public class PersonModel {

    private final Person person;
    private boolean isExpanded;

    public PersonModel(Person person, boolean isExpanded) {
        this.person = person;
        this.isExpanded = isExpanded;
    }

    public Person getPerson() {
        return person;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
