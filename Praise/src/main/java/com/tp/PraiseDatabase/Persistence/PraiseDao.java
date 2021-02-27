package com.tp.PraiseDatabase.Persistence;

import com.tp.PraiseDatabase.Exceptions.InvalidArtistsException;
import com.tp.PraiseDatabase.Exceptions.InvalidSongException;
import com.tp.PraiseDatabase.Exceptions.InvalidTitleException;
import com.tp.PraiseDatabase.Models.Song;

import java.util.*;

public interface PraiseDao {
    Integer addSong(String title, List<String> artists, String key, String timeSig, String tempo, String pdfUrl) throws InvalidTitleException, InvalidArtistsException, InvalidSongException;
    Song deleteSong(Integer songID) throws InvalidSongException;
    Song getSongByID(Integer songID) throws InvalidSongException;
    List<String> getArtistByID(Integer songID);
    List<Song> getAllSong();
}
