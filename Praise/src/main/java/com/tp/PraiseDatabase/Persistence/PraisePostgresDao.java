package com.tp.PraiseDatabase.Persistence;

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
@Profile("production")
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
    private Integer getArtistID(String artist) {
        List<Integer> id = new ArrayList<>();
        id =  template.query("select \"artistID\" from \"Artists\" where \"artistName\" = '" + artist + "'", new IDMapper());
        if (id.isEmpty()) return null;
        else return id.get(0);
    }
    //adds artist if artist doesn't exist
    private Integer addArtist(String artist) {
        return template.query("insert into public.\"Artists\" (\"artistName\")\n" +
                "values ('" + artist + "')\n" +
                "returning \"artistID\" as \"ID\";", new IDMapper()).get(0);
    }



    class IDMapper implements RowMapper<Integer>{
        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("ID");
        }
    }
}
