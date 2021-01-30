package com.tp.LibraryCollection.persistence;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.Book;
import com.tp.LibraryCollection.models.LibraryCollection;
import com.tp.LibraryCollection.services.Rng;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LibraryCollectionInMemDao implements LibraryCollectionDao{

    private LibraryCollection library;

    public LibraryCollectionInMemDao() {
        library = new LibraryCollection();
    }

    /**
     * Gets the book by it's ID.
     * @param bookID
     * @return Book
     * @throws InvalidBookIDException
     */
    @Override
    public Book getBookByID(Integer bookID) throws InvalidBookIDException {
        if (bookID == null) throw new InvalidBookIDException("The number given was null. Enter in a correct number");
        return library.findBook(bookID);
    }


    /**
     * Get all the Books by returning LibraryCollection HashMap<>\
     * @return library
     */
    @Override
    public LibraryCollection getAllBooks() {
        return library;
    }

    /**
     * Updates the book by grabbing all the needed information.
     * @param bookID
     * @param title
     * @param author
     * @param yearPublished
     * @return Book
     * @throws InvalidBookException
     */
    @Override
    public Book updateBook(Integer bookID, String title, String author, Integer yearPublished) throws InvalidBookException {
        Book book = null;
        if (!library.containsBook(bookID)) {
            throw new InvalidBookException("No books with that ID is in the collection.");
        } else {
            book = library.findBook(bookID);
            book.setTitle(title);
            book.setAuthor(author);
            book.setYearPublished(yearPublished);
        }
        return book;
    }

    /**
     * Overloaded method of updateBook for multiiple authors.
     * @param bookID
     * @param title
     * @param authors
     * @param yearPublished
     * @return Book
     * @throws InvalidBookException
     */
    @Override
    public Book updateBook(Integer bookID, String title, List<String> authors, Integer yearPublished) throws InvalidBookException {
        Book book = null;
        if (!library.containsBook(bookID)) {
            throw new InvalidBookException("No books with that ID is in the collection.");
        } else {
            book = library.findBook(bookID);
            book.setTitle(title);
            book.setAuthors(authors);
            book.setYearPublished(yearPublished);
        }
        return book;
    }

    /**
     * This starts the collection/adds book to collection.
     * @param title
     * @param author
     * @param yearPublished
     * @return bookID
     * @throws InvalidYearPublishedException
     * @throws InvalidAuthorException
     * @throws OverloadLibraryException
     */
    @Override
    public int startCollection(String title, String author, Integer yearPublished) throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException {
        if (yearPublished == null) {
            throw new InvalidYearPublishedException("Tried to start a collection with a year published that is null");
        }
        if (yearPublished < 618 && yearPublished > 2021)
            throw new InvalidYearPublishedException("Published Year are within the boundaries of 618 AD and 2021 AD");
        if (author == null || author.equals("")) {
            throw new InvalidAuthorException("Tried to start a new collection with a author that is null or empty string");
        }
        if (library.sizeOfLibrary() >= 99900)
            throw new OverloadLibraryException("Collection of books is now full. Delete a book in collection if you want to add.");

        int bookID = Rng.nextInt(100, 100000);

        while (library.containsBook(bookID)) {
            bookID = Rng.nextInt(100, 100000);
        }
        library.addBook(bookID, title, author, yearPublished);
        return bookID;
    }

    /**
     * Overloaded method of startCollection for authors.
     * @param title
     * @param authors
     * @param yearPublished
     * @return bookID
     * @throws InvalidYearPublishedException
     * @throws InvalidAuthorException
     * @throws OverloadLibraryException
     */
    @Override
    public int startCollection(String title, List<String> authors, Integer yearPublished) throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException {
        if (yearPublished == null) {
            throw new InvalidYearPublishedException("Tried to start a collection with a year published that is null");
        }
        if (authors == null) {
            throw new InvalidAuthorException("Tried to start a new collection with a author that is null");
        }
        if (library.sizeOfLibrary() >= 99900)
            throw new OverloadLibraryException("Collection of books is now full. Delete a book in collection if you want to add.");

        int bookID = Rng.nextInt(100, 100000);

        while (library.containsBook(bookID)) {
            bookID = Rng.nextInt(100, 100000);
        }
        library.addBook(bookID, title, authors, yearPublished);
        return bookID;
    }

    /**
     * Deletes the book from the LibraryCollection HashMap<>
     * @param bookID
     * @return Book
     * @throws InvalidBookIDException
     */
    @Override
    public Book deleteBook(Integer bookID) throws InvalidBookIDException {
        Book book = null;
        if (bookID == null) throw new InvalidBookIDException("The number retrieved was null.");
        book = library.removeBook(bookID);
        if (book == null) {
            throw new InvalidBookIDException("This bookID doesn't exist in the collection.");
        }
        return book;
    }

}
