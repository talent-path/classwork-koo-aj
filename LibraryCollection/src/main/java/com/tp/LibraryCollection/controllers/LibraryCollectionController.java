package com.tp.LibraryCollection.controllers;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.LibraryCollectionViewModel;
import com.tp.LibraryCollection.services.LibraryCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class LibraryCollectionController {

    @Autowired
    LibraryCollectionService service;

    /**
     * STARTS THE LIBRARY AND FILLS IT.
     * @param request
     * @return
     */
    @PostMapping("/define")
    public ResponseEntity newBookEntry(@RequestBody GuessRequest request ) {
        LibraryCollectionViewModel vM = null;
        try {
            if (request.getAuthors() == null)
                vM = service.startCollection(request.getTitle(), request.getAuthor(), request.getYearPublished());
            else
                vM = service.startCollection(request.getTitle(), request.getAuthors(), request.getYearPublished());
        } catch (InvalidBookIDException e) {
            e.printStackTrace();
        } catch (OverloadLibraryException e) {
            e.printStackTrace();
        } catch (InvalidYearPublishedException e) {
            e.printStackTrace();
        } catch (InvalidAuthorException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(vM);
    }

    /**
     * GET ALL BOOKS FROM COLLECTION
     * @return
     */
    @GetMapping("/allBooks")
    public List<LibraryCollectionViewModel>  getAllBooks(){
        return service.getAllBooksFromCollection();
    }

    /**
     * FIND BOOKS BY ID
     * @param bookID
     * @return
     * @throws InvalidBookIDException
     */
    @GetMapping("/booksBy/ID/{bookID}")
    public LibraryCollectionViewModel  getBookByID(@PathVariable Integer bookID) throws InvalidBookIDException {
        return service.getBookByID(bookID);
    }

    /**
     * FINDS BOOKS BY STARTING STRINGS
     * @param startsWith
     * @return
     */
    @GetMapping("/booksBy/titleStartsWith/{startsWith}")
    public List<LibraryCollectionViewModel> getAllBooksThatsStartsWith(@PathVariable String startsWith) {
        return service.getAllBooksStartsWith(startsWith);
    }

    /**
     * FIND BOOKS BY AUTHORS
     * @param author
     * @return
     */
    @GetMapping("/booksBy/author/{author}")
    public List<LibraryCollectionViewModel> getBooksByAuthor(@PathVariable String author) {
        return service.getBooksThroughAuthor(author);
    }

    /**
     * FINDS BOOKS BY YEAR
     * @param year
     * @return
     */
    @GetMapping("/booksBy/yearPublished/{year}")
    public List<LibraryCollectionViewModel> getBooksByYear(@PathVariable Integer year) {
        return service.getBooksWithYear(year);
    }

    /**
     * DELETES BOOKS
     * @param bookID
     * @return
     * @throws InvalidBookIDException
     */
    @DeleteMapping("/delete/{bookID}")
    public LibraryCollectionViewModel removeBookByID(@PathVariable Integer bookID) throws InvalidBookIDException {
        return service.removeBookByID(bookID);
    }

    /**
     * EDITS BOOKS
     * @param request
     * @return
     */
    @PostMapping("/edit")
    public LibraryCollectionViewModel editBook(@RequestBody GuessRequest request) {
        LibraryCollectionViewModel vM = null;
        try {
            if (request.getAuthors() == null)
                vM = service.editByID(request.getbookID(), request.getTitle(), request.getAuthor(), request.getYearPublished());
            else vM = service.editByID(request.getbookID(), request.getTitle(), request.getAuthors(), request.getYearPublished());
        } catch (InvalidBookException e) {
            e.printStackTrace();
        } catch (InvalidBookIDException e) {
            e.printStackTrace();
        }
        return vM;
    }


}
