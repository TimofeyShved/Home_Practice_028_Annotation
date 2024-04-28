package com.company;

public class Book {

    private String name;
    private String author;

    @XMLElement(name = "book")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XMLAtribute(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
