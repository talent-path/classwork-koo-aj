package com.tp.PraiseDatabase.Persistence;

import com.tp.PraiseDatabase.Exceptions.InvalidArtistsException;
import com.tp.PraiseDatabase.Exceptions.InvalidSongException;
import com.tp.PraiseDatabase.Exceptions.InvalidTitleException;
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
        template.update("INSERT INTO \"Songs\"(\"title\", \"key\", \"timeSignature\", \"tempo\", \"pdfUrl\")\n" +
                "VALUES ('Jesus, I Love You', 'C','4/4', 'Slow', 'www.google.com');");
        template.update("INSERT INTO public.\"Artists\"(\n" +
                "\t\"artistName\")\n" +
                "\tVALUES ('Chris Tomlin');");
        template.update("INSERT INTO public.\"SongArtist\"(\n" +
                "\t\"artistID\", \"songID\")\n" +
                "\tVALUES ('1', '1');");

        template.update("INSERT INTO \"Songs\"(\"title\", \"key\", \"timeSignature\", \"tempo\", \"pdfUrl\")\n" +
                "VALUES ('I Could Sing of Your Love Forever', 'A','4/4', 'Medium/Fast', 'www.google.com')");
        template.update("INSERT INTO public.\"Artists\"(\n" +
                "\t\"artistName\")\n" +
                "\tVALUES ('Shane and Shane'), ('Matt Redman');");
        template.update("INSERT INTO public.\"SongArtist\"(\n" +
                "\t\"artistID\", \"songID\")\n" +
                "\tVALUES ('2', '2');");
        template.update("INSERT INTO public.\"SongArtist\"(\n" +
                "\t\"artistID\", \"songID\")\n" +
                "\tVALUES ('3', '2');");
    }

    @Test
    public void updateSongGoldenPathTest() throws InvalidSongException {
        List<Integer> n = template.query("select \"artistID\" as ID from \"SongArtist\" where \"songID\" = '1';", new PraisePostgresDao.IDMapper());
        assertEquals(n.get(0), 1);
        assertEquals(n.size(), 1);
        List<String> artistList = new ArrayList<>();
        artistList.add("Lauren Daigle");
        artistList.add("Kirk Franklin");
        List<Integer> artists = new ArrayList<>();
        for (String artist : artistList) {
            Integer artistID = toTest.addOrRetrieve(artist);
            artists.add(artistID);
        }
        Song song = toTest.updateSong(1, "How Great Thou Art", artistList, "A", "4/4", "Fast", "google.com");
        toTest.linkSongArtist(artists, 1);
        List<Integer> m = template.query("select \"artistID\" as ID from \"SongArtist\" where \"songID\" = '1';", new PraisePostgresDao.IDMapper());
        assertEquals(m.get(0), 4);
        assertEquals(m.get(1), 5);
    }

    @Test
    public void addSongGoldenPathTest() throws InvalidSongException {
        // TODO: 1. initialize song
        List<String> artistList = new ArrayList<>();
        artistList.add("Chris Tomlin");
        artistList.add("Lauren Daigle");
        artistList.add("Matt Redman");
        assertEquals(toTest.addSong("How Great Is Our God", artistList, "A","4/4", "Medium", "www.google.com"), 3);
    }

    @Test
    public void addSongNull() {
        List<String> artistList = new ArrayList<>();
        artistList.add("Chris Tomlin");

        try {
            assertEquals(toTest.addSong(null, artistList, "A","4/4", "Medium", "www.google.com"), null);
            fail();
        } catch (InvalidSongException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(toTest.addSong("Hello", null, "A","4/4", "Medium", "www.google.com"), null);
            fail();
        } catch (InvalidSongException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(toTest.addSong("Hello", artistList, null,"4/4", "Medium", "www.google.com"), null);
            fail();
        } catch (InvalidSongException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(toTest.addSong("Hello", artistList, "A",null, "Fast", "www.google.com"), null);
            fail();
        } catch (InvalidSongException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(toTest.addSong("Hello", artistList, "A","4/4", null, "www.google.com"), null);
            fail();
        } catch (InvalidSongException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(toTest.addSong("Hello", artistList, "A","4/4", "Medium", null), null);
            fail();
        } catch (InvalidSongException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getArtistIDGoldenPathTest() {
        assertEquals(toTest.getArtistID("Chris Tomlin"), 1);
        assertEquals(toTest.getArtistID("Shane and Shane"), 2);
        assertEquals(toTest.getArtistID("Lauren Daigle"), null);
    }
    @Test
    public void deleteBySongIDTest() throws InvalidSongException {
        Song song = toTest.deleteSong(1);
        assertEquals(song.getSongID(), 1);
        assertEquals(song.getArtists().get(0), "Chris Tomlin");
        assertEquals(song.getPdfUrl(), "https://www.google.com");
        assertEquals(song.getTempo(), "Medium/Fast");
        assertEquals(song.getTimeSig(), "4/4");
    }

    @Test
    public void getBySongIDTest() throws InvalidSongException {
        Song song = toTest.getSongByID(1);
        assertEquals(song.getSongID(), 1);
        assertEquals(song.getArtists().get(0), "Chris Tomlin");
        assertEquals(song.getPdfUrl(), "https://www.google.com");
        assertEquals(song.getTempo(), "Medium/Fast");
        assertEquals(song.getTimeSig(), "4/4");
    }

    @Test
    public void addArtistGoldenPathTest() {
        assertEquals(toTest.addArtist("Lauren Daigle"), 4);
    }

    @Test
    public void addOrRetrieveGoldenPathTest() throws InvalidSongException {
        assertEquals(toTest.addOrRetrieve("Chris Tomlin"), 1);
        assertEquals(toTest.addOrRetrieve("Shane and Shane"), 2);
        assertEquals(toTest.addOrRetrieve("Lauren Daigle"), 4);
    }
}
