package com.tp.PraiseDatabase.Services;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("serviceTest")
public class PraiseServiceTests {

    @Autowired
    PraiseService toTest;

    @Test
    public void addSongTest() {

    }

}
