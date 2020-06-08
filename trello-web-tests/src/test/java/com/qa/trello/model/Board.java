package com.qa.trello.model;

import java.util.Objects;

public class Board {
    private String name;
    private String team;
    private String color;


    public Board withName(String name) {
        this.name = name;
        return this;
    }

    public Board withTeam(String team) {
        this.team = team;
        return this;
    }

    public Board withColor(String color) {
        this.color = color;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
