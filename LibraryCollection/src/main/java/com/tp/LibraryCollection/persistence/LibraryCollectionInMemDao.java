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
        return new Book(library.findBook(bookID));
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
     * Overloaded method of updateBook for multiiple authors.
     * @param bookID
     * @param title
     * @param authors
     * @param yearPublished
     * @return Book
     * @throws InvalidBookException
     */
    @Override
    public Book updateBook(Integer bookID, String title, List<String> authors, Integer yearPublished) throws InvalidBookException, InvalidTitleException, InvalidYearPublishedException, InvalidAuthorException {
        Book book = null;
        if (!library.containsBook(bookID)) {
            throw new InvalidBookException("No books with that ID is in the collection.");
        } else {
            if (title == null) {
                throw new InvalidTitleException("Tried to add a book when book title is null.");
            }
            if (yearPublished == null) {
                throw new InvalidYearPublishedException("Tried to start a collection with a year published that is null");
            }
            if (yearPublished < 618 || yearPublished > 2021)
                throw new InvalidYearPublishedException("Published Year are within the boundaries of 618 AD and 2021 AD");
            if (authors == null) {
                throw new InvalidAuthorException("Tried to start a new collection with author(s) that is null");
            }
            book = library.findBook(bookID);
            book.setTitle(title);
            book.setAuthors(authors);
            book.setYearPublished(yearPublished);
        }
        return new Book(book);
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
    public int addBook(String title, List<String> authors, Integer yearPublished) throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException, InvalidTitleException {
        if (title == null) {
            throw new InvalidTitleException("Tried to add a book when book title is null.");
        }
        if (yearPublished == null) {
            throw new InvalidYearPublishedException("Tried to start a collection with a year published that is null");
        }
        if (yearPublished < 618 || yearPublished > 2021)
            throw new InvalidYearPublishedException("Published Year are within the boundaries of 618 AD and 2021 AD");
        if (authors == null) {
            throw new InvalidAuthorException("Tried to start a new collection with author(s) that is null");
        }
        if (library.sizeOfLibrary() >= 100000)
            throw new OverloadLibraryException("Collection of books is now full. Delete a book in collection if you want to add.");

        int bookID = 0;
        for (int prevBookID : library.iterator()) {
            if (bookID < prevBookID)
                bookID = prevBookID;
        }
        bookID++;

        // was randomly generating but not anymore
//        while (library.containsBook(bookID)) {
//            bookID = Rng.nextInt(100, 100000);
//        }
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
        return new Book(book);
    }
    @Override
    public List<Book> getBookStartsWith(String startsWith) throws InvalidBookIDException {
        List<Book> list = new ArrayList<>();
        for (int bookID : this.getAllBooks().iterator()) {
            if (this.getBookByID(bookID).getTitle().startsWith(startsWith))
                list.add(this.getBookByID(bookID));
        }
        return list;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) throws InvalidBookIDException {
        List<Book> list = new ArrayList<>();
        for (int bookID : this.getAllBooks().iterator())
            for (String curAuthor : this.getBookByID(bookID).getAuthors())
                if (curAuthor.contains(author))
                    list.add(this.getBookByID(bookID));
        return list;
    }

    @Override
    public List<Book> getBooksByPublishedYear(Integer year) throws InvalidBookIDException {
        List<Book> list = new ArrayList<>();
        for (int bookID : this.getAllBooks().iterator())
            if (this.getBookByID(bookID).getYearPublished().equals(year))
                list.add(this.getBookByID(bookID));
        return list;
    }

}
