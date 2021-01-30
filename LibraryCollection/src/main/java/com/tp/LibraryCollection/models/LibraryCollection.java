package com.tp.LibraryCollection.models;

import java.util.*;

public class LibraryCollection {

    private HashMap<Integer, Book> collectionOfBooks;

    /**
     * Constructor
     */
    public LibraryCollection() {
        collectionOfBooks = new HashMap<Integer, Book>();
    }

    /**
     * Collection for the ViewModel
     * @param that
     */
    public LibraryCollection( LibraryCollection that ){
        this.collectionOfBooks = that.collectionOfBooks;;
    }

    /**
     * This is to add the book into the collection hashmap. There is one single author
     * in this addBook method.
     * @param bookID
     * @param title
     * @param name
     * @param yearPublished
     * @return Book
     */
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

    /**
     * This is an overloaded method of add book. Instead of one single author there are multiple
     * authors.
     * @param bookID
     * @param title
     * @param name
     * @param yearPublished
     * @return
     */
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

    /**
     * This will remove the book from Collection HashMap by bookID.
     * Returns null if it does not exist.
     * @param bookID
     * @return Book
     */
    public Book removeBook(int bookID) {
        try {
            return collectionOfBooks.remove(bookID);
        } catch(NullPointerException e) {
            return null;
        }
    }

    /**
     * This will go through the HashMap and checks if the
     * Book exist. We find the book through bookID.
     * @param bookID
     * @return Book
     */
    public Book findBook(int bookID) {
        try {
            return collectionOfBooks.get(bookID);
        } catch(NullPointerException e) {
            return null;
        }
    }

    /**
     * This method returns true if the book is in the Collection.
     * If not, it will return false.
     * @param bookID
     * @return true or false
     */
    public boolean containsBook(int bookID) {
        return collectionOfBooks.containsKey(bookID);
    }

    /**
     * We check the size of the library (collection). Set the Library so it can only take
     * in a total of 990,000 books.
     * @return size of the library.
     */
    public int sizeOfLibrary() {
        return collectionOfBooks.size();
    }

    /**
     * This is the iterator that will let us traverse through the Library
     * to find the book. Uses keySet() from the HashMap<> API.
     * @return Set<Integer> set of bookID
     */
    public Set<Integer> iterator() {
        return collectionOfBooks.keySet();
    }

}
