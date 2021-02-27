package com.tp.PraiseDatabase.Persistence;

import com.tp.PraiseDatabase.Models.Song;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("serviceTest")
public class PraiseInMemDao implements PraiseDao {
    @Override
    public Integer addSong(String title, List<String> artists, String key, String timeSig, String tempo, String pdfUrl) {
        return null;
    }

    @Override
    public Song deleteSong(Integer songID) {
        return null;
    }

    @Override
    public Song getSongByID(Integer songID) {
        return null;
    }

    @Override
    public List<String> getArtistByID(Integer songID) {
        return null;
    }

    @Override
    public List<Song> getAllSong() {
        return null;
    }
}
