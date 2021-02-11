package com.tp.PraiseDatabase.Persistence;

import com.tp.PraiseDatabase.Models.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("daoTesting")
public class PraisePostgresDaoTests {

    @Autowired
    PraisePostgresDao toTest;
    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setUp() {
        // TODO: TRUNCATE EVERYTHING BEFORE TESTING
        template.update("TRUNCATE \"SongArtist\", \"Songs\", \"Artists\" RESTART IDENTITY;");
        // TODO: INSERT
        template.update("INSERT INTO public.\"Songs\"(\n" +
                "\ttitle, \"timeSignature\", tempo, \"pdfUrl\")\n" +
                "\tVALUES ('Forever', '4/4', 'Medium/Fast', 'https://www.google.com');");
        template.update("INSERT INTO public.\"Artists\"(\n" +
                "\t\"artistName\")\n" +
                "\tVALUES ('Chris Tomlin');");
        template.update("INSERT INTO public.\"SongArtist\"(\n" +
                "\t\"artistID\", \"songID\")\n" +
                "\tVALUES ('1', '1');");

        template.update("INSERT INTO public.\"Songs\"(\n" +
                "\ttitle, \"timeSignature\", tempo, \"pdfUrl\")\n" +
                "\tVALUES ('I Could Sing of Your Love Forever', '4/4', 'Medium', 'https://www.google.com');");
        template.update("INSERT INTO public.\"Artists\"(\n" +
                "\t\"artistName\")\n" +
                "\tVALUES ('Shane and Shane');");
        template.update("INSERT INTO public.\"SongArtist\"(\n" +
                "\t\"artistID\", \"songID\")\n" +
                "\tVALUES ('2', '2');");
    }

    @Test
    public void addSongGoldenPathTest() {
        // TODO: 1. initialize song
        List<String> artistList = new ArrayList<>();
        artistList.add("Chris Tomlin");
        assertEquals(toTest.addSong("How Great Is Our God", artistList, "4/4", "Medium", "www.google.com"), 3);

    }

    @Test
    public void getArtistIDGoldenPathTest() {
        assertEquals(toTest.getArtistID("Chris Tomlin"), 1);
        assertEquals(toTest.getArtistID("Shane and Shane"), 2);
        assertEquals(toTest.getArtistID("Lauren Daigle"), 3);
    }

    @Test
    public void addArtistGoldenPathTest() {
        assertEquals(toTest.addArtist("Lauren Daigle"), 3);
    }

    @Test
    public void addOrRetrieveGoldenPathTest() {
        assertEquals(toTest.addOrRetrieve("Chris Tomlin"), 1);
        assertEquals(toTest.addOrRetrieve("Shane and Shane"), 2);
        assertEquals(toTest.addOrRetrieve("Lauren Daigle"), 3);
    }
}
