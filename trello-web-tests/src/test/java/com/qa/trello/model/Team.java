package com.qa.trello.model;

public class Team {
    private String name;

    public Team withName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

}
