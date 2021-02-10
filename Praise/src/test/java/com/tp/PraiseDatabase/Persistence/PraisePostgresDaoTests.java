package com.tp.PraiseDatabase.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class PraisePostgresDaoTests {

    @Autowired
    PraisePostgresDao toTest;
    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setUp() {
        // TODO: TRUNCATE EVERYTHING BEFORE TESTING

        // TODO: INSERT
        template.update("INSERT INTO public.\"Songs\"(\n" +
                "\t\"songID\", title, \"timeSignature\", tempo, \"pdfUrl\")\n" +
                "\tVALUES (?, ?, ?, ?, ?);");
    }

    @Test
    public void addSongGoldenPathTest() {
        // TODO: 1. initialize song


    }
}
