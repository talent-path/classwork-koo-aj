package com.tp.LibraryCollection.models;
import java.util.*;
public class Book {

    public Integer getBookID() {
        return bookID;
    }

    private Integer bookID;


    public String getAuthor() {
        return author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public boolean isAuthorVersusAuthors() {
        if (this.getAuthor() != null && this.getAuthors() == null)
            return true;
        else
            return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    // TODO: To be more specific could have used the name class.
    private String author;
    private List<String> authors;
    private Integer yearPublished;
    private Name name;

    /**
     * This constructor is a book with one author.
     * @param bookID
     * @param author
     * @param yearPublished
     */
    public Book(Integer bookID, String title, String author, Integer yearPublished) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.authors = null;
        this.yearPublished = yearPublished;
    }

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
        this.author = null;
        this.yearPublished = yearPublished;
    }


}
