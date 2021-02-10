package com.tp.LibraryCollection.persistence;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class LibraryCollectionInMemTests {

    private int bookID1;
    private int bookID2;
    private List<String> authors1;
    private List<String> authors2;
    @Autowired
    LibraryCollectionInMemDao toTest;
    @BeforeEach
    public void setUp() throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException, InvalidTitleException {
        toTest = new LibraryCollectionInMemDao();
        this.authors1 = new ArrayList<>();
        authors1.add("AJ Koo");
        bookID1 = toTest.addBook("Book1", authors1, 1996);
        this.authors2 = new ArrayList<>();
        authors2.add("Tim Kim");
        authors2.add("Brian Sopata");
        bookID2 = toTest.addBook("Book2", authors2, 1997);
    }

    @Test
    public void testAddBook() throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException, InvalidBookIDException, InvalidTitleException {
        // Golden Path
        List<String> authors1 = new ArrayList<>();
        authors1.add("Walter Isaacson");
        int bookID1 = toTest.addBook("Book", authors1, 1999);

        List<String> authors2 = new ArrayList<>();
        authors2.add("JK Rowling");
        authors2.add("Malcolm Gladwell");
        int bookID2 = toTest.addBook("Book2", authors2, 2000);
        assertEquals(bookID1, toTest.getBookByID(bookID1).getBookID());
        assertEquals(toTest.getBookByID(bookID1).getAuthors().get(0), "Walter Isaacson");
        assertEquals(toTest.getBookByID(bookID1).getTitle(), "Book");
        assertEquals(toTest.getBookByID(bookID1).getYearPublished(), 1999);

        assertEquals(bookID2, toTest.getBookByID(bookID2).getBookID());
        assertEquals(toTest.getBookByID(bookID2).getAuthors().get(0), "JK Rowling");
        assertEquals(toTest.getBookByID(bookID2).getAuthors().get(1), "Malcolm Gladwell");
        assertEquals(toTest.getBookByID(bookID2).getTitle(), "Book2");
        assertEquals(toTest.getBookByID(bookID2).getYearPublished(), 2000);

        assertNotEquals(bookID1, bookID2);
    }

    @Test
    public void testAddBookTitleNull() {

        try {
            toTest.addBook(null, authors1, 1999);
        } catch(InvalidTitleException | InvalidYearPublishedException | InvalidAuthorException | OverloadLibraryException e) {

        }
    }

    @Test
    public void testAddBookAuthorNull() {
        try {
            toTest.addBook("Title", null, 1999);
        } catch(InvalidAuthorException | InvalidYearPublishedException | OverloadLibraryException | InvalidTitleException e) {

        }
    }

    @Test
    public void testAddBookYearPublishedNull() {
        // When year published is null
        try {
            toTest.addBook("Title", authors1, null);
        } catch(InvalidYearPublishedException | InvalidAuthorException | OverloadLibraryException | InvalidTitleException e) {

        }
    }

    @Test
    public void testGetAllBooks() throws InvalidBookIDException {
        assertEquals(toTest.getBookByID(bookID1).getTitle(), "Book1");
        assertEquals(toTest.getBookByID(bookID1).getYearPublished(), 1996);
        assertEquals(toTest.getBookByID(bookID1).getAuthors().get(0), "AJ Koo");
        assertEquals(toTest.getBookByID(bookID2).getTitle(), "Book2");
        assertEquals(toTest.getBookByID(bookID2).getYearPublished(), 1997);
        assertEquals(toTest.getBookByID(bookID2).getAuthors().get(0), "Tim Kim");
        assertEquals(toTest.getBookByID(bookID2).getAuthors().get(1), "Brian Sopata");
    }

    @Test
    public void testGetBooksByID() throws InvalidBookIDException {

        for (int bookID : toTest.getAllBooks().iterator()) {
            if (toTest.getBookByID(bookID).getTitle().equals("Book1")) {
                assertEquals(1996, toTest.getBookByID(bookID).getYearPublished());
                assertEquals("AJ Koo", toTest.getBookByID(bookID).getAuthors().get(0));
            } else if (toTest.getBookByID(bookID).getTitle().equals("Book2")) {
                assertEquals(1997, toTest.getBookByID(bookID).getYearPublished());
                assertEquals("Tim Kim", toTest.getBookByID(bookID).getAuthors().get(0));
                assertEquals("Brian Sopata", toTest.getBookByID(bookID).getAuthors().get(1));
            }
        }
    }

    @Test
    public void testEditBook() throws InvalidBookIDException, InvalidBookException, InvalidTitleException, InvalidYearPublishedException, InvalidAuthorException {
        int testID1 = 0;
        int testID2 = 0;
        for (int bookID : toTest.getAllBooks().iterator()) {
            if (toTest.getBookByID(bookID).getTitle().equals("Book1")) {
                testID1 = bookID;
                toTest.updateBook(bookID, "Book2", authors2, 1997);
            } else if (toTest.getBookByID(bookID).getTitle().equals("Book2")) {
                toTest.updateBook(bookID, "Book1", authors1, 1996);
            }
        }
        for (int bookID : toTest.getAllBooks().iterator()) {
            if (toTest.getBookByID(bookID).getTitle().equals("Book1")) {
                testID2 = bookID;
                assertEquals(1996, toTest.getBookByID(bookID).getYearPublished());
                assertEquals("AJ Koo", toTest.getBookByID(bookID).getAuthors().get(0));
            } else if (toTest.getBookByID(bookID).getTitle().equals("Book2")) {
                assertEquals(1997, toTest.getBookByID(bookID).getYearPublished());
                assertEquals("Tim Kim", toTest.getBookByID(bookID).getAuthors().get(0));
                assertEquals("Brian Sopata", toTest.getBookByID(bookID).getAuthors().get(1));
            }
        }
        assertNotEquals(testID1, testID2);
    }

    @Test
    public void testDelete() throws InvalidBookIDException {
        Book b1 = toTest.deleteBook(bookID1);
        assertEquals(b1.getTitle(), "Book1");
        assertEquals(b1.getAuthors().get(0), "AJ Koo");
        assertEquals(b1.getYearPublished(), 1996);
        assertEquals(b1.getBookID(), 1);
        Book b2 = toTest.deleteBook(bookID2);
        assertEquals(b2.getTitle(), "Book2");
        assertEquals(b2.getAuthors().get(0), "Tim Kim");
        assertEquals(b2.getAuthors().get(1), "Brian Sopata");
        assertEquals(b2.getYearPublished(), 1997);
        assertEquals(b2.getBookID(), 2);

        try {
            toTest.deleteBook(3);
            fail();
        }catch (InvalidBookIDException e) {

        }
    }

    @Test
    public void testGetBooksByAuthor() {
    }

    @Test
    public void testGetBooksByTitle() {

    }

    @Test
    public void testGetBooksByTitleYear() {

    }

    @Test
    public void testGetBooksByPublishedYear() {

    }

}
