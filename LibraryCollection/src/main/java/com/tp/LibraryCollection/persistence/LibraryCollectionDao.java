package com.tp.LibraryCollection.persistence;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.Book;
import com.tp.LibraryCollection.models.LibraryCollection;

import java.util.List;

public interface LibraryCollectionDao {
    Book getBookByID(Integer bookID) throws InvalidBookIDException;

    LibraryCollection getAllBooks();

    Book updateBook(Integer bookId, String title, List<String> author, Integer yearPublished) throws InvalidBookException, InvalidTitleException, InvalidYearPublishedException, InvalidAuthorException;

    int addBook(String title, List<String> authors, Integer yearPublished) throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException, InvalidTitleException;

    Book deleteBook(Integer bookID) throws InvalidBookIDException;

    List<Book> getBookStartsWith(String startsWith) throws InvalidBookIDException;

    List<Book> getBooksByAuthor(String author) throws InvalidBookIDException;

    List<Book> getBooksByPublishedYear(Integer year) throws InvalidBookIDException;
}
