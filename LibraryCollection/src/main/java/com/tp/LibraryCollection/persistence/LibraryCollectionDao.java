package com.tp.LibraryCollection.persistence;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.Book;
import com.tp.LibraryCollection.models.LibraryCollection;

import java.util.List;

public interface LibraryCollectionDao {
    Book getBookByID(Integer bookID) throws InvalidBookIDException;

    LibraryCollection getAllBooks();

    Book updateBook(Integer bookId, String title, String author, Integer yearPublished) throws InvalidBookException;

    Book updateBook(Integer bookId, String title, List<String> author, Integer yearPublished) throws InvalidBookException;
    //returns bookID
    // should throw nulls for
    // InvalidBookIDException, InvalidAuthorIDException, and InvalidYearPublishedException
    int startCollection(String title, String author, Integer yearPublished) throws OverloadLibraryException, InvalidYearPublishedException, InvalidAuthorException;

    // returns bookID
    // should throw nulls for
    // TODO: LOOK AT NEXT LINE InvalidAuthorIDException (QUESTIONABLE)
    // InvalidBookIDException, InvalidAuthorIDException (QUESTIONABLE), and InvalidYearPublishedException
    int startCollection(String title, List<String> authors, Integer yearPublished) throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException;

    Book deleteBook(Integer bookID) throws InvalidBookIDException;
}
