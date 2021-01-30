package com.tp.LibraryCollection.controllers;

import java.util.*;
public class GuessRequest {

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public int getbookID() {
        return bookID;
    }

    private int bookID;
    private String title;
    private String author;
    private List<String> authors;
    private Integer yearPublished;
}
