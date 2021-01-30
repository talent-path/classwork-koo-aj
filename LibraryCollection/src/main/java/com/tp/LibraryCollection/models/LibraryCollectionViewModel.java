package com.tp.LibraryCollection.models;

import java.util.*;

public class LibraryCollectionViewModel {
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Integer getBookID() {
        return bookID;
    }



    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }



    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    private String title;
    private String author;
    private List<String> authors;
    private Integer bookID;
    private Integer publishedYear;
}