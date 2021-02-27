package com.tp.PraiseDatabase.Services;

import com.tp.PraiseDatabase.Exceptions.InvalidArtistsException;
import com.tp.PraiseDatabase.Exceptions.InvalidSongException;
import com.tp.PraiseDatabase.Exceptions.InvalidTitleException;
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

    public Song addSong(String title, List<String> artists, String key, String timeSig, String tempo, String pdfUrl) throws InvalidSongException {
        List<Integer> artistList = new ArrayList<>();
        for (String artist : artists) {
            Integer artistID = dao.addOrRetrieve(artist);
            artistList.add(artistID);
        }
        Integer songID = dao.addSong(title, artists, key, timeSig, tempo, pdfUrl);
        dao.linkSongArtist(artistList, songID);
        return new Song(songID, title, artists, key, timeSig, tempo, pdfUrl);
    }

    public Song deleteSong(Integer songID) throws InvalidSongException {
        Song song = dao.deleteSong(songID);
        return song;
    }

    public List<Song> getAllSongs() {
        return dao.getAllSong();
    }

    public Song editBook(Integer songID, String title, List<String> artists, String key, String timeSig, String tempo, String pdfUrl) throws InvalidSongException {
        List<Integer> artistList = new ArrayList<>();
        for (String artist : artists) {
            Integer artistID = dao.addOrRetrieve(artist);
            artistList.add(artistID);
        }
        Song song = dao.updateSong(songID, title, artists, key, timeSig, tempo, pdfUrl);
        dao.linkSongArtist(artistList, songID);
        return song;
    }

    public List<Song> getSongsByTitle(String title) {
        return dao.getSongsByTitle(title);
    }

    public List<Song> getSongsByArtist(String artist) {
        return dao.getSongsByArtist(artist);
    }
}
