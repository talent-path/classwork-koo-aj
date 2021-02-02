package com.tp.LibraryCollection.models;
import java.util.*;
public class Book {

    public Integer getBookID() {
        return bookID;
    }

    private Integer bookID;

    public Integer getYearPublished() {
        return yearPublished;
    }

    public List<String> getAuthors() {
        return authors;
    }


    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private List<String> authors;
    private Integer yearPublished;



    /**
     * This constructor is for a book with multiple authors.
     * @param bookID
     * @param authors
     * @param yearPublished
     */
    public Book(Integer bookID, String title, List<String> authors, Integer yearPublished) {
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        this.yearPublished = yearPublished;
    }
    public Book(Book that) {
        this.bookID = that.bookID;
        this.title = that.title;
        List<String> list = new ArrayList<>();
        list.addAll(that.authors);
        this.authors = list;
        this.yearPublished = that.yearPublished;
    }


}
