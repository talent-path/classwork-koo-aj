package com.tp.LibraryCollection.persistence;

import com.tp.LibraryCollection.exceptions.InvalidAuthorException;
import com.tp.LibraryCollection.exceptions.InvalidYearPublishedException;
import com.tp.LibraryCollection.exceptions.OverloadLibraryException;
import com.tp.LibraryCollection.models.LibraryCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class LibraryCollectionInMemTests {

    @Autowired
    LibraryCollectionInMemDao toTest;
    @BeforeEach
    public void setUp() throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException {
        LibraryCollection allGames = toTest.getAllBooks();
        for (int b : allGames.iterator()) {
            allGames.removeBook(b);
        }
        toTest.startCollection("Outliers", "Malcolm Gladwell", 2008);
    }

    @Test
    public void testStartCollectionGoldenPath() {
        int id = 0;
        for (int i : toTest.getAllBooks().iterator()) {
            id = i;
        }
        String testTitle = "Outliers";
        String testAuthor = "Malcolm Gladwell";
        assertEquals(testTitle, toTest.getAllBooks().findBook(id).getTitle());
        assertEquals(testAuthor, toTest.getAllBooks().findBook(id).getAuthor());
        assertEquals(null, toTest.getAllBooks().findBook(id).getAuthors());
        assertEquals(2008, toTest.getAllBooks().findBook(id).getYearPublished());
    }

    @Test
    public void testStartCollectionInvalidAuthorException() {
        LibraryCollection allGames = toTest.getAllBooks();
        for (int b : allGames.iterator()) {
            allGames.removeBook(b);
        }
        try {
            toTest.startCollection("Outliers", (String)null, 2008);
            fail();
        } catch (InvalidYearPublishedException  | InvalidAuthorException | OverloadLibraryException e) {

        }
    }

}
