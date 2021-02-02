package com.tp.LibraryCollection.models;

import java.util.*;

/**
 * This is the ViemModel class where the ViewModel allows us to see
 * on Postman.
 */
public class LibraryCollectionViewModel {

    private String title;
    private String author;
    private List<String> authors;
    private Integer bookID;
    private Integer publishedYear;

    public String getTitle() {
        return title;
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

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }



    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
}
