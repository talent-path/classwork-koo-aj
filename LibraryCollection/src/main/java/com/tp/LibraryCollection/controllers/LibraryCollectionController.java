package com.tp.LibraryCollection.controllers;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.Book;
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
    public ResponseEntity newBookEntry(@RequestBody Book request) {
        LibraryCollectionViewModel vM = null;
        try {
            vM = service.addBook(request.getTitle(), request.getAuthors(), request.getYearPublished());
        } catch (InvalidBookIDException | OverloadLibraryException | InvalidYearPublishedException | InvalidAuthorException | InvalidTitleException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(vM);
    }
    /**
     * EDITS BOOKS
     * @param request
     * @return
     */
    @PutMapping("/edit")
    public ResponseEntity editBook(@RequestBody Book request) {
        LibraryCollectionViewModel vM = null;
        try {
            vM = service.editBook(request.getBookID(), request.getTitle(), request.getAuthors(), request.getYearPublished());
        } catch (InvalidBookException | InvalidBookIDException |
                InvalidYearPublishedException | InvalidTitleException | InvalidAuthorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(vM);
    }

    /**
     * GET ALL BOOKS FROM COLLECTION
     * @return
     */
    @GetMapping("/allBooks")
    public List<LibraryCollectionViewModel>  getAllBooks(){
        return service.getAllBooks();
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
    public List<LibraryCollectionViewModel> getAllBooksThatStartsWith(@PathVariable String startsWith) throws InvalidBookIDException {
        return service.getBookStartsWith(startsWith);
    }

    /**
     * FIND BOOKS BY AUTHORS
     * @param author
     * @return
     */
    @GetMapping("/booksBy/author/{author}")
    public List<LibraryCollectionViewModel> getBooksByAuthor(@PathVariable String author) throws InvalidBookIDException {
        return service.getBooksAuthor(author);
    }

    /**
     * FINDS BOOKS BY YEAR
     * @param year
     * @return
     */
    @GetMapping("/booksBy/yearPublished/{year}")
    public List<LibraryCollectionViewModel> getBooksByYear(@PathVariable Integer year) throws InvalidBookIDException {
        return service.getBookPublishedYear(year);
    }

    /**
     * DELETES BOOKS
     * @param bookID
     * @return
     * @throws InvalidBookIDException
     */
    @DeleteMapping("/delete/{bookID}")
    public LibraryCollectionViewModel removeBookByID(@PathVariable Integer bookID) throws InvalidBookIDException {
        return service.deleteBook(bookID);
    }
}
