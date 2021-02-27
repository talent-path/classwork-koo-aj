package com.tp.PraiseDatabase.Persistence;

import com.tp.PraiseDatabase.Exceptions.InvalidSongException;
import com.tp.PraiseDatabase.Models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
@Profile({"production", "daoTesting"})
public class PraisePostgresDao implements PraiseDao {
    @Autowired
    private JdbcTemplate template;

    public PraisePostgresDao() {
        template = new JdbcTemplate();
    }

    @Override
    public Integer addSong(String title, List<String> artists, String key, String timeSig, String tempo, String pdfUrl) throws InvalidSongException {
        // add song to the praise database
        if (title == null || title.length() < 2)
            throw new InvalidSongException("Needs a longer title to be a sufficient title.");
        if (artists == null || artists.size() == 0)
            throw new InvalidSongException("At least one artist must be mentioned");
        if (artists.size() > 0) {
            for (int i = 0; i < artists.size(); i++) {
                String s = artists.get(i);
                if (s.length() < 2) throw new InvalidSongException("Artist name needs to be longer than one letter.");
            }
        }
        if (timeSig == null || timeSig.length() > 3)
            throw new InvalidSongException("Time signature has to be denoted in this manner: 'numerator/denominator'. EX: 4/4");
        if (tempo == null) throw new InvalidSongException("type down the tempo of this song.");
        String checkTempo = tempo.toLowerCase();
        if (!checkTempo.equals("slow") && !checkTempo.equals("medium") && !checkTempo.equals("fast")
        && !checkTempo.equals("slow/medium") && !checkTempo.equals("medium/fast") && !checkTempo.equals("slow/medium/fast"))
            throw new InvalidSongException("Tempo must be one of these six choices: \n" +
                    "Slow \n Medium \n Fast \n Slow/Medium \n Medium/Fast \n Slow/Medium/Fast");
        if (pdfUrl == null) throw new InvalidSongException("Write a url please.");
        Integer songID = template.query("INSERT INTO \"Songs\"(\"title\", \"key\", \"timeSignature\", \"tempo\", \"pdfUrl\")\n" +
                "VALUES ('"+ title +"', '"+ key +"','"+ timeSig +"', '"+ tempo +"', '"+ pdfUrl +"')\n" +
                "RETURNING \"songID\" as \"ID\"; ", new IDMapper()).get(0);

        return songID;
    }
    @Override
    public List<Song> getAllSong() {
        List<Song> songList = template.query("SELECT \"songID\", \"title\", " +
                "\"tempo\", \"timeSignature\", \"pdfUrl\" FROM \"Songs\"", new songMapper());
        for (Song song : songList) {
            List<String> artists = getArtistByID(song.getSongID());
            song.setArtists(artists);
        }
        return songList;
    }
    @Override
    public Song getSongByID(Integer songID) throws InvalidSongException {
        Song song = template.query("SELECT \"songID\", \"title\", \"timeSignature\", \"tempo\", \"pdfUrl\" \n" +
                "\tFROM \"Songs\" \n" +
                "\tWHERE \"songID\" = '" + songID + "';", new songMapper()).get(0);
        if (song == null) throw new InvalidSongException("This song does not exist in the database");
        song.setArtists(getArtistByID(songID));
        return song;
    }

    @Override
    public List<String> getArtistByID(Integer songID) {
        List<String> list = template.query("SELECT \"artistName\"" +
                "\tFROM \"Artists\" \n" +
                "\tLEFT JOIN \"SongArtist\" AS \"sa\"\n" +
                "\tON \"sa\".\"artistID\" = \"Artists\".\"artistID\"\n" +
                "\tWHERE \"sa\".\"songID\" = '" + songID + "';", new artistMapper());
        return list;
    }

    @Override
    public Song deleteSong(Integer songID) throws InvalidSongException {
        Song song = getSongByID(songID);
        template.execute("DELETE FROM \"SongArtist\" WHERE \"songID\" = '" + songID + "';");
        template.execute("DELETE FROM \"Songs\" WHERE \"songID\" = '" + songID + "';");
        return song;
    }

    public void linkSongArtist(List<Integer> artistIDList, Integer songID) {
        for (Integer artistID : artistIDList) {
            template.execute("INSERT INTO public.\"SongArtist\"(\n" +
                    "\t\"artistID\", \"songID\")\n" +
                    "\tVALUES (" + artistID + ", " + songID + ");");
        }
    }



    // We are either adding a new "author" or we're retrieving an author that already exist.
    public Integer addOrRetrieve(String artist) throws InvalidSongException {
        Integer authorID = getArtistID(artist);
        if (authorID == null)
            authorID = addArtist(artist);
        return authorID;
    }

    // we are getting the author id that already exist;
    // if it doesn't exist we return null
    public Integer getArtistID(String artist) {
        List<Integer> id = new ArrayList<>();
        id =  template.query("select \"artistID\" as \"ID\" from \"Artists\" where \"artistName\" = '" + artist + "';", new IDMapper());
        if (id.isEmpty()) return null;
        else return id.get(0);
    }
    //adds artist if artist doesn't exist
    public Integer addArtist(String artist){
        Integer artistID = template.query("insert into public.\"Artists\" (\"artistName\")\n" +
                "values ('" + artist + "')\n" +
                "returning \"artistID\" as \"ID\";", new IDMapper()).get(0);
        return artistID;
    }

    public Song updateSong(Integer songID, String title, List<String> artists, String key, String timeSig, String tempo, String pdfUrl) throws InvalidSongException {
        if (songID == null) throw new InvalidSongException("No ID entered. Please enter in ID.");
        if (title == null || title.length() < 2)
            throw new InvalidSongException("Needs a longer title to be a sufficient title.");
        if (artists == null || artists.size() == 0)
            throw new InvalidSongException("At least one artist must be mentioned");
        if (artists.size() > 0) {
            for (int i = 0; i < artists.size(); i++) {
                String s = artists.get(i);
                if (s.length() < 2) throw new InvalidSongException("Artist name needs to be longer than one letter.");
            }
        }
        if (timeSig == null || timeSig.length() > 3)
            throw new InvalidSongException("Time signature has to be denoted in this manner: 'numerator/denominator'. EX: 4/4");
        if (tempo == null) throw new InvalidSongException("type down the tempo of this song.");
        String checkTempo = tempo.toLowerCase();
        if (!checkTempo.equals("slow") && !checkTempo.equals("medium") && !checkTempo.equals("fast")
                && !checkTempo.equals("slow/medium") && !checkTempo.equals("medium/fast") && !checkTempo.equals("slow/medium/fast"))
            throw new InvalidSongException("Tempo must be one of these six choices: \n" +
                    "Slow \n Medium \n Fast \n Slow/Medium \n Medium/Fast \n Slow/Medium/Fast");
        if (pdfUrl == null) throw new InvalidSongException("Write a url please.");
        template.execute("UPDATE \"Songs\" \n" +
                "\tSET \"title\" = '" + title +"'\n" +
                "\tWHERE \"Songs\".\"songID\" = '" + songID + "'");
        template.execute("UPDATE \"Songs\" \n" +
                "\tSET \"key\" = '" + key +"'\n" +
                "\tWHERE \"Songs\".\"songID\" = '" + songID + "'");
        template.execute("UPDATE \"Songs\" \n" +
                "\tSET \"timeSignature\" = '"+ timeSig +"'\n" +
                "\tWHERE \"Songs\".\"songID\" = '" + songID + "'");
        template.execute("UPDATE \"Songs\" \n" +
                "\tSET \"tempo\" = '" + tempo +"'\n" +
                "\tWHERE \"Songs\".\"songID\" = '" + songID + "'");
        template.execute("UPDATE \"Songs\" \n" +
                "\tSET \"pdfUrl\" = '" + pdfUrl +"'\n" +
                "\tWHERE \"Songs\".\"songID\" = '" + songID + "'");
        template.execute("DELETE FROM \"SongArtist\" WHERE \"songID\" = '" + songID + "';");
        return new Song(songID, title, artists, key, timeSig, tempo, pdfUrl);
    }

    public List<Song> getSongsByTitle(String title) {
        List<Song> songList = template.query("SELECT \"songID\", \"title\", " +
                "\"tempo\", \"timeSignature\", \"pdfUrl\" FROM \"Songs\"", new songMapper());
        for (Song song : songList) {
            List<String> artists = getArtistByID(song.getSongID());
            song.setArtists(artists);
        }
        List<Song> shavedSongList = new ArrayList<>();
        for (Song song : songList) {
            if (song.getTitle().equals(title) || song.getTitle().contains(title))
                shavedSongList.add(song);
        }
        return shavedSongList;
    }

    public List<Song> getSongsByArtist(String artist) {
        List<Song> songList = template.query("SELECT \"songID\", \"title\", " +
                "\"tempo\", \"timeSignature\", \"pdfUrl\" FROM \"Songs\"", new songMapper());
        for (Song song : songList) {
            List<String> artists = getArtistByID(song.getSongID());
            song.setArtists(artists);
        }
        List<Song> shavedSongList = new ArrayList<>();
        for (Song song : songList) {
            if (song.getTitle().equals(artist) || song.getTitle().contains(artist))
                shavedSongList.add(song);
        }
        return shavedSongList;
    }


    static class IDMapper implements RowMapper<Integer>{
        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("ID");
        }
    }

    class songMapper implements RowMapper<Song> {
        @Override
        public Song mapRow(ResultSet resultSet, int i) throws SQLException {
            Integer songID = resultSet.getInt("songID");
            String title = resultSet.getString("title");
            String key = resultSet.getString("key");
            String timeSig = resultSet.getString("timeSignature");
            String tempo = resultSet.getString("tempo");
            String pdfUrl = resultSet.getString("pdfUrl");
            Song song = new Song(songID, title, null, key, timeSig, tempo, pdfUrl);
            return song;
        }
    }
    class artistMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString("artistName");
        }
    }

}
