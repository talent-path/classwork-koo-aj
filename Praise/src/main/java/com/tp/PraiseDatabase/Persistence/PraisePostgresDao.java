package com.tp.PraiseDatabase.Persistence;

import com.tp.PraiseDatabase.Models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
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
    public Integer addSong(String title, List<String> artists, String timeSig, String tempo, String pdfUrl) {
        // add song to the praise database
        Integer songID = template.query("INSERT INTO public.\"Songs\"(title, \"timeSignature\", tempo, \"pdfUrl\")\n" +
                "\tVALUES ('" + title + "', '" + timeSig + "', '" + tempo + "', '" + pdfUrl + "') " +
                " RETURNING \"songID\" as \"ID\";", new IDMapper()).get(0);

        return songID;
    }
    @Override
    public Song getSongByID(Integer songID) {
        //TODO : NEXT UP!
        return null;
    }

    @Override
    public Song deleteSong(Integer songID) {
        Song song = getSongByID(songID);
        template.execute("DELETE FROM public.\"Songs\"\n" +
                "\tWHERE \"artistID\" = '';");
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
    public Integer addOrRetrieve(String artist) {
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
    public Integer addArtist(String artist) {
        Integer artistID = template.query("insert into public.\"Artists\" (\"artistName\")\n" +
                "values ('" + artist + "')\n" +
                "returning \"artistID\" as \"ID\";", new IDMapper()).get(0);
        System.out.println(artistID);
        return artistID;
    }


    class IDMapper implements RowMapper<Integer>{
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
            List<String> artists = null;
            String timeSig = resultSet.getString("timeSignature");
            String tempo = resultSet.getString("tempo");
            String pdfUrl = resultSet.getString("pdfUrl");
            Song song = new Song(songID, title, artists, timeSig, tempo, pdfUrl);
            return song;
        }
    }
}
