package com.tp.LibraryCollection.models;

import java.util.*;

public class LibraryCollection {

    private HashMap<Integer, Book> collectionOfBooks;

    public LibraryCollection() {
        collectionOfBooks = new HashMap<Integer, Book>();
    }
    public LibraryCollection( LibraryCollection that ){
        this.collectionOfBooks = that.collectionOfBooks;;
    }

    public Book addBook(int bookID, String title, String name, Integer yearPublished) {
        try {
            Book book = new Book(bookID, title, name, yearPublished);
            collectionOfBooks.put(bookID, book);
            return book;
        } catch (NullPointerException e) {
            e.getStackTrace();
            return new Book(0, "nullTitle", "nullAuthor", 0);
        }
    }
    public Book addBook(int bookID, String title, List<String> name, Integer yearPublished) {
        try {
            Book book = new Book(bookID, title, name, yearPublished);
            collectionOfBooks.put(bookID, book);
            return book;
        } catch (NullPointerException e) {
            e.getStackTrace();
            return new Book(0, "nullTitle", "nullAuthor", 0);
        }
    }

    public Book removeBook(int bookID) {
        try {
            return collectionOfBooks.remove(bookID);
        } catch(NullPointerException e) {
            return null;
        }
    }

    public Book findBook(int bookID) {
        try {
            return collectionOfBooks.get(bookID);
        } catch(NullPointerException e) {
            return null;
        }
    }

    public boolean containsBook(int bookID) {
        return collectionOfBooks.containsKey(bookID);
    }

    public int sizeOfLibrary() {
        return collectionOfBooks.size();
    }

    public Set<Integer> iterator() {
        return collectionOfBooks.keySet();
    }

}
