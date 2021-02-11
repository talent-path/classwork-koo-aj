package com.tp.PraiseDatabase.Services;

import com.tp.PraiseDatabase.Models.Song;
import com.tp.PraiseDatabase.Persistence.PraisePostgresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PraiseService {
    @Autowired
    PraisePostgresDao dao;

    public Song addSong(String title, List<String> artists, String timeSig, String tempo, String pdfUrl) {
        List<Integer> artistList = new ArrayList<>();
        for (String artist : artists) {
            Integer artistID = dao.addOrRetrieve(artist);
            artistList.add(artistID);
        }
        Integer songID = dao.addSong(title, artists, timeSig, tempo, pdfUrl);
        dao.linkSongArtist(artistList, songID);
        return new Song(songID, title, artists, timeSig, tempo, pdfUrl);
    }

    public Song deleteSong(Integer songID) {
        Song song = dao.deleteSong(songID);
        return song;
    }
}
