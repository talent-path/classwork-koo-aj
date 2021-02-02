package com.tp.LibraryCollection.services;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LibraryCollectionServiceTests {

    private LibraryCollectionService service;
    @BeforeEach
    public void setUp() {
        service = new LibraryCollectionService();

    }


}
