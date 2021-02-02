package com.tp.LibraryCollection.services;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.Book;
import com.tp.LibraryCollection.models.LibraryCollection;
import com.tp.LibraryCollection.models.LibraryCollectionViewModel;
import com.tp.LibraryCollection.persistence.LibraryCollectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LibraryCollectionService {
    @Autowired
    LibraryCollectionDao dao;

    public LibraryCollectionViewModel addBook(String title, List<String> authors, Integer yearPublished) throws InvalidYearPublishedException, OverloadLibraryException, InvalidAuthorException, InvalidBookIDException, InvalidTitleException {
        int id = dao.addBook(title, authors, yearPublished);
        return convertModel(dao.getBookByID(id));
    }

    public LibraryCollectionViewModel deleteBook(Integer bookID) throws InvalidBookIDException {
        Book book = dao.deleteBook(bookID);
        return convertModel(book);
    }

    public LibraryCollectionViewModel editBook(Integer bookID, String title, List<String> authors, Integer yearPublished) throws InvalidBookIDException, InvalidBookException, InvalidTitleException, InvalidYearPublishedException, InvalidAuthorException {
        Book book = dao.updateBook(bookID, title, authors, yearPublished);
        return convertModel(book);
    }

    public LibraryCollectionViewModel getBookByID(Integer bookID) throws InvalidBookIDException {
        Book book = dao.getBookByID(bookID);
        return convertModel( book );
    }

    public List<LibraryCollectionViewModel> getBookStartsWith(String startsWith) throws InvalidBookIDException {
        List<Book> books = dao.getBookStartsWith(startsWith);
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Book book : books)
            list.add(convertModel(book));
        return list;
    }

    public List<LibraryCollectionViewModel> getBooksAuthor(String author) throws InvalidBookIDException {
        List<Book> books = dao.getBooksByAuthor(author);
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Book book : books)
            list.add(convertModel(book));
        return list;
    }

    public List<LibraryCollectionViewModel> getBookPublishedYear(Integer year) throws InvalidBookIDException {
        List<Book> books = dao.getBooksByPublishedYear(year);
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Book book : books)
            list.add(convertModel(book));
        return list;
    }
    public List<LibraryCollectionViewModel> getAllBooks() {
        LibraryCollection lC = dao.getAllBooks();
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Integer toConvert : lC.iterator()) {
            list.add(convertModel(lC.findBook(toConvert)));
        }
        return list;
    }

    private LibraryCollectionViewModel convertModel(Book book) {
        LibraryCollectionViewModel vM = new LibraryCollectionViewModel();
        vM.setTitle(book.getTitle());
        vM.setAuthors(book.getAuthors());
        vM.setPublishedYear(book.getYearPublished());
        vM.setBookID(book.getBookID());
        return vM;
    }

}
