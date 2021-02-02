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


}
