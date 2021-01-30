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

    public LibraryCollectionViewModel startCollection(String title, String author, Integer yearPublished) throws InvalidYearPublishedException, OverloadLibraryException, InvalidAuthorException, InvalidBookIDException {
        int id = dao.startCollection(title, author, yearPublished);
        return convertModel(dao.getBookByID(id));
    }

    public LibraryCollectionViewModel startCollection(String title, List<String> authors, Integer yearPublished) throws InvalidYearPublishedException, OverloadLibraryException, InvalidAuthorException, InvalidBookIDException {
        int id = dao.startCollection(title, authors, yearPublished);
        return convertModel(dao.getBookByID(id));
    }

    public LibraryCollectionViewModel getBookByID(Integer bookID) throws InvalidBookIDException {
        Book book = dao.getBookByID(bookID);
        return convertModel( book );
    }

    public LibraryCollectionViewModel removeBookByID(Integer bookID) throws InvalidBookIDException {
        Book book = dao.deleteBook(bookID);
        return convertModel(book);
    }

    public LibraryCollectionViewModel editByID(Integer bookID, String title, String author, Integer yearPublished) throws InvalidBookIDException, InvalidBookException {
        Book book = dao.updateBook(bookID, title, author, yearPublished);
        return convertModel(book);
    }
    public LibraryCollectionViewModel editByID(Integer bookID, String title, List<String> authors, Integer yearPublished) throws InvalidBookIDException, InvalidBookException {
        Book book = dao.updateBook(bookID, title, authors, yearPublished);
        return convertModel(book);
    }


    public List<LibraryCollectionViewModel> getAllBooksStartsWith(String startsWith) {
        LibraryCollection lC = dao.getAllBooks();
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Integer toConvert : lC.iterator()) {
            if (lC.findBook(toConvert).getTitle().startsWith(startsWith))
                list.add(convertModel(lC.findBook(toConvert)));
        }
        return list;
    }

    public List<LibraryCollectionViewModel> getBooksThroughAuthor(String author) {
        LibraryCollection lC = dao.getAllBooks();
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Integer toConvert : lC.iterator()) {
            if (lC.findBook(toConvert).isAuthorVersusAuthors()) {
                if (lC.findBook(toConvert).getAuthor().contains(author)) {
                    list.add(convertModel(lC.findBook(toConvert)));
                }
            } else {
                for (String curAuthor : lC.findBook(toConvert).getAuthors()) {
                    if (curAuthor.contains(author)) {
                        list.add(convertModel(lC.findBook(toConvert)));
                    }
                }
            }
        }
        return list;
    }

    public List<LibraryCollectionViewModel> getBooksWithYear(Integer year) {
        LibraryCollection lC = dao.getAllBooks();
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Integer toConvert : lC.iterator()) {
            if (lC.findBook(toConvert).getYearPublished().equals(year))
                list.add(convertModel(lC.findBook(toConvert)));
        }
        return list;
    }
    public List<LibraryCollectionViewModel> getAllBooksFromCollection() {
        LibraryCollection lC = dao.getAllBooks();
        List<LibraryCollectionViewModel> list = new ArrayList<>();
        for (Integer toConvert : lC.iterator()) {
            list.add(convertModel(lC.findBook(toConvert)));
        }
        return list;
    }

    private LibraryCollectionViewModel convertModel(Book book) {
        LibraryCollectionViewModel vM = new LibraryCollectionViewModel();
        if (book.isAuthorVersusAuthors()) {
            vM.setTitle(book.getTitle());
            vM.setAuthor(book.getAuthor());
            vM.setPublishedYear(book.getYearPublished());
            vM.setBookID(book.getBookID());
        } else {
            vM.setTitle(book.getTitle());
            vM.setAuthors(book.getAuthors());
            vM.setPublishedYear(book.getYearPublished());
            vM.setBookID(book.getBookID());
        }
        return vM;
    }

}
