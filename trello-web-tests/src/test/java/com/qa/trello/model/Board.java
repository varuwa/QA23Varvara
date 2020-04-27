package com.qa.trello.model;

public class Board {
    private String name;

    public Board withName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
