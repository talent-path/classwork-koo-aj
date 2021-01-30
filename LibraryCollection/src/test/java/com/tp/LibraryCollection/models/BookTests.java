package com.tp.LibraryCollection.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
@SpringBootTest
public class BookTests {

    Book book1;
    Book book2;
    String author1;
    String author2;
    String author3;
    List<String> authors1;
    @BeforeEach
    public void setUp() {
        author1 = "Malcolm Gladwell";
        author2 = "John Calvin";
        author3 = "Martin Luther";
        authors1 = new ArrayList<>();
    }

    @Test
    public void testIsAuthorVersusAuthorsGoldenPath() {
        book1 = new Book(100, "Outlier", author1, 2008);
        authors1.add(author2);
        authors1.add(author3);
        book2 = new Book(101, "Reformation", authors1, 1455);
        assertEquals(true, book1.isAuthorVersusAuthors());
        assertEquals(false, book2.isAuthorVersusAuthors());
        book1.setAuthors(authors1);
        assertEquals(false, book1.isAuthorVersusAuthors());
    }
}
