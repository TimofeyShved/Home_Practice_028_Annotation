package com.company;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBook() {
        return books;
    }

    public void setBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return " Books { " +
                " List<Book> = " + books.toString() +
                " } ";
    }
}
